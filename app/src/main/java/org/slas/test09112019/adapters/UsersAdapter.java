package org.slas.test09112019.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.slas.test09112019.R;
import org.slas.test09112019.constants.ViewType;
import org.slas.test09112019.data.model.Name;
import org.slas.test09112019.data.model.User;
import org.slas.test09112019.presentation.base.adapter.BaseViewHolder;
import org.slas.test09112019.presentation.base.adapter.RecyclerItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsersAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    private boolean isLoaderVisible = false;
    private OnItemClickListener onItemClickListener;

    private Context context;
    private List<RecyclerItem> usersList;

    public UsersAdapter(Context context, List<RecyclerItem> recyclerItemList) {
        this.context = context;
        this.usersList = recyclerItemList;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case VIEW_TYPE_NORMAL:
                return new UsersViewHolder(LayoutInflater.from(context)
                        .inflate(R.layout.item_user, parent, false));

            case VIEW_TYPE_LOADING:
                return new LoadingViewHolder(
                        LayoutInflater.from(context)
                        .inflate(R.layout.item_loading, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible){
            return position == usersList.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else{
            return VIEW_TYPE_NORMAL;
        }
    }

    @Override
    public int getItemCount() {
        return usersList == null ? 0 : usersList.size();
    }

    public void addItems(List<RecyclerItem> users){
        usersList.addAll(users);
        notifyDataSetChanged();
    }

    public void addLoading(){
        isLoaderVisible = true;
        usersList.add(() -> ViewType.LOADING_VIEW_TYPE);
        notifyItemInserted(usersList.size() - 1);
    }

    public void removeLoading(){
        isLoaderVisible = false;
        int positionLoading = usersList.size() - 1;
        if (usersList.isEmpty()) return;
        if (usersList.get(positionLoading).getViewType() == ViewType.LOADING_VIEW_TYPE){
            usersList.remove(positionLoading);
            notifyItemRemoved(positionLoading);
        }
    }

    public User getItem(int position){
        return (User) usersList.get(position);
    }


    public class UsersViewHolder extends BaseViewHolder{

        private ImageView imageViewPhoto;
        private TextView textViewName;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            textViewName = itemView.findViewById(R.id.textViewName);

            itemView.setOnClickListener(view -> {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            RecyclerItem recyclerItem = usersList.get(position);

            if (recyclerItem instanceof User){
                User user = (User) recyclerItem;

                Name objectName = user.getName();
                String name = objectName.getFirst() + " " + objectName.getLast();
                textViewName.setText(name);

                Glide.with(context)
                        .load(user.getPicture().getThumbnail())
                        .into(imageViewPhoto);
            }

        }
    }

    public class LoadingViewHolder extends BaseViewHolder{

        LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        protected void clear() {

        }
    }
}
