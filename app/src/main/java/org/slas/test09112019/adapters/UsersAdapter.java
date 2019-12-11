package org.slas.test09112019.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.slas.test09112019.R;
import org.slas.test09112019.data.model.Name;
import org.slas.test09112019.data.model.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{

    private Context context;
    private ArrayList<User> usersList;

    public UsersAdapter(Context context, ArrayList<User> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.user_item, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User user = usersList.get(position);

        Name objectName = user.getName();
        String name = objectName.getFirst() + " " + objectName.getLast();
        holder.textViewName.setText(name);

        Glide.with(context)
                .load(user.getPicture().getThumbnail())
                .into(holder.imageViewPhoto);
    }

    @Override
    public int getItemCount() {
        return usersList.size()
                ;
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewPhoto;
        private TextView textViewName;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }
}
