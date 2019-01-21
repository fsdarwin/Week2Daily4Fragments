package com.example.week2daily4fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements UserInput.OnFragmentInteractionListener{

    UserInput inputFrag;
    OutputInfo outputFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputFrag = new UserInput();
        outputFrag = new OutputInfo();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.flInput, inputFrag).commit();
        fm.beginTransaction().replace(R.id.flOutput, outputFrag).commit();
    }

    @Override
    public void sendToActivity(UserInfo userInfo) {
        OutputInfo.setDisplay(userInfo);
    }
}
