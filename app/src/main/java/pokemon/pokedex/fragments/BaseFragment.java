package pokemon.pokedex.fragments;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import pokemon.pokedex.activities.BaseActivity;
import pokemon.pokedex.controller.ReadExcel;

/**
 * Created by DuongLH1 on 8/12/2016.
 */
public class BaseFragment extends Fragment {

    BaseActivity activity;
    ReadExcel readExcel;
    Application application;
    FragmentManager fragmentManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (BaseActivity) this.getActivity();
        application = activity.getApplication();
        readExcel = new ReadExcel(application);
        fragmentManager = activity.getSupportFragmentManager();
    }
}
