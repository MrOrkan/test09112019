package org.slas.test09112019.presentation.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public abstract class BaseFragment<T extends BaseViewModel> extends Fragment {

    protected NavController navController;
    private T viewModel;

    protected abstract T createViewModel();

    @LayoutRes
    protected abstract Integer getLayout();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = createViewModel();
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        viewModel = createViewModel();
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);//todo is needed
    }

}
