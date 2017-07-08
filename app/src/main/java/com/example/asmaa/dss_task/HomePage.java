package com.example.asmaa.dss_task;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        boolean is_login  =  getIntent().getExtras()
                .getBoolean("is_login");

        Bundle b = new Bundle();
        b.putBoolean("is_login",is_login);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(b);
        transaction.replace(R.id.linear_layout,mainFragment);
        transaction.commit();

    }
}
