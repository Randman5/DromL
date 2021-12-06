package ru.droml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import ru.droml.databinding.ActivityMainBinding;
import ru.droml.utlis.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarMode(this);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(activityMainBinding.toolbar.searchToolbar);

    }
}