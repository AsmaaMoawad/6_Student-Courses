package com.example.asmaa.dss_task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Asmaa on 14-Apr-17.
 */

public class MainFragment extends Fragment {

    TabLayout tabLayout;
    CustomViewPager viewPager;

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        boolean is_login  =  getArguments().getBoolean("is_login");

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (CustomViewPager) view.findViewById(R.id.pagers);
        if(!is_login){
            viewPager.setPagingEnabled(false);

        }


        TapAdapter adapter = new TapAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);


        tabLayout.post(new Runnable() {
            @Override
            public void run() {

                tabLayout.setupWithViewPager(viewPager);
            }
        });



        if(!is_login){
            LinearLayout tabStrip = ((LinearLayout)tabLayout.getChildAt(0));
            for(int i = 0; i < tabStrip.getChildCount(); i++) {
                tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return true;
                    }
                });
            }
        }



        return view;
    }

    private class TapAdapter extends FragmentPagerAdapter {


        public TapAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    return new Tab1_ForgetPass();
                default:
                    return new Tab2_Courses();
            }

        }

        @Override
        public int getCount() {
            return 2;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {

                case 0:

                    return "Forget Password";

                default:
                    return "Courses";
            }

        }
    }
}


