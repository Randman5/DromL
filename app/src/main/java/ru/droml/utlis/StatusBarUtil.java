package ru.droml.utlis;

import android.content.res.Configuration;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import ru.droml.R;

public class StatusBarUtil {

    public static <T extends AppCompatActivity> void setStatusBarMode(T activity) {

        int nightModeFlags = activity.getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;


        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                setDarkMode(activity);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                setLightMode(activity);
                break;

            default:
                setLightMode(activity);
                break;
        }
    }

    private static <T extends AppCompatActivity> void setDarkMode(T activity){
        activity.setTheme(R.style.Theme_DromL_Dark);
        Window window = activity.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(activity, R.color.cardview_shadow_end_color));
    }

    private static <T extends AppCompatActivity> void setLightMode(T activity) {
        Window window = activity.getWindow();
        activity.setTheme(R.style.Theme_DromL_Light);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(activity.getResources().getColor(R.color.cardview_light_background)); // set dark color, the icon will auto change light
    }

}
