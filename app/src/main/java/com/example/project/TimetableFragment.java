package com.example.project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimetableFragment extends Fragment {


    public TimetableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timetable, container, false);



    }
    public void selectFragment(MenuItem tag){
//        Fragment fragment = null;
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (tag.getItemId()){
            case R.id.monday:
                MonTTFragment a = new MonTTFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, a).commit();
                break;

            case R.id.tuesday:
                TueTTFragment b = new TueTTFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, b).commit();
                break;
        }
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }


}
