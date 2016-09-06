package pokemon.pokedex.activities;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import pokemon.pokedex.controller.ReadExcel;

/**
 * Created by DuongLH1 on 8/12/2016.
 */
public class BaseActivity extends AppCompatActivity {

    ReadExcel readExcel;
    Application application;
    FragmentManager fragmentManager;
    Context context;
    OnBackPressedListener onBackPressedListener;
    public interface OnBackPressedListener {
        void doBack();
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = getApplication();
        context = BaseActivity.this;
        readExcel = new ReadExcel(application);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onBackPressed() {
        if (onBackPressedListener !=null) {
            onBackPressedListener.doBack();
        }else super.onBackPressed();
    }
}
