package org.slas.test09112019.presentation.main.list;

import android.util.Log;

import org.slas.test09112019.R;
import org.slas.test09112019.presentation.base.BaseViewModel;

public class StartListViewModel extends BaseViewModel<StartListNavigator> {

    
    public void onButtonClick(){
        getNavigator().showProfileFragment();
        Log.i("TEST", "we are inside click");
    }
}
