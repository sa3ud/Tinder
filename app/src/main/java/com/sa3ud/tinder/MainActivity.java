package com.sa3ud.tinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_host,
                    new HomeFragment())
                    .commit();
        }


    }



    private Fragment getCurrentFragment() {

        return getSupportFragmentManager().findFragmentById(R.id.fl_host);

    }


    @Override
    public void onBackPressed() {


        if (getCurrentFragment() instanceof HomeFragment) {

            if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText(getBaseContext(), "Press once again to exit!",
                        Toast.LENGTH_SHORT).show();
            }
            back_pressed = System.currentTimeMillis();

        } else {

            super.onBackPressed();
        }

    }}