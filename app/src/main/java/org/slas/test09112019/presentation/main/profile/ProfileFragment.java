package org.slas.test09112019.presentation.main.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.slas.test09112019.R;
import org.slas.test09112019.data.model.User;
import org.slas.test09112019.presentation.base.BaseFragment;
import org.slas.test09112019.presentation.main.MainViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends BaseFragment<ProfileViewModel> {

    private final static String TITLE_PROFILE = "Profile";

    private ProfileViewModel profileViewModel;
    private MainViewModel mainViewModel;

    private Bundle bundle;
    private User user;

    private CircleImageView circleImageViewPhoto;
    private TextView textViewName;
    private TextView textViewYearsOld;
    private EditText editTextPhoneNumber;
    private EditText editTextEmail;
    private Button buttonCall;


    @Override
    protected ProfileViewModel createViewModel() {
        return ViewModelProviders.of(this).get(ProfileViewModel.class);
    }

    @Override
    protected Integer getLayout() {
        return R.layout.fragment_main_profile;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        circleImageViewPhoto = view.findViewById(R.id.circleImageViewPhoto);
        textViewName = view.findViewById(R.id.textViewName);
        textViewYearsOld = view.findViewById(R.id.textViewYearsOld);
        editTextPhoneNumber = view.findViewById(R.id.editTextPhoneNumber);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        buttonCall = view.findViewById(R.id.buttonCall);

        init();
        setupLiveData();
        setupAdapter();
    }

    private void init(){
        if (getActivity() != null){
            mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
            mainViewModel.updateActionBarTitle(TITLE_PROFILE);
        }

        bundle = getArguments();
        if (bundle != null){
            user = bundle.getParcelable("user");
        }

        Glide.with(this)
                .load(user.getPicture().getLarge())
                .into(circleImageViewPhoto);
        textViewName.setText(user.getName().getFirstAndLastName());
        textViewYearsOld.setText(String.valueOf(user.getDob().getAge())
                                                .concat(getString(R.string.years_old_profile)));
        editTextPhoneNumber.setText(user.getPhone());
        editTextEmail.setText(user.getEmail());

        buttonCall.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse(getString(R.string.tel_dial_profile).concat(user.getPhone())));
            startActivity(intent);
        });

    }

    private void setupLiveData(){

    }

    private void setupAdapter(){

    }


}
