package com.example.week2daily4fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class OutputInfo extends Fragment {

    Context context = getActivity();
    RecyclerView recyclerView;
    static RVAdapter rvAdapter;
    ArrayList<UserInfo> userInfoArrayList;
    public static final String TAG = "FRANK: ";

    public OutputInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_output_info, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userInfoArrayList = new ArrayList<>();
        rvAdapter = new RVAdapter(userInfoArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView = view.findViewById(R.id.rvOutput);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);
        userInfoArrayList = listOfUsers();
        Log.d(TAG, "onViewCreated: array size"+ rvAdapter.getItemCount() );
    }

    public static void setDisplay(UserInfo userInfo){
        rvAdapter.addUser(userInfo);
    }

    public ArrayList<UserInfo> listOfUsers() {
        userInfoArrayList.add(new UserInfo("Marcy", "marcy@mail.com", "mr fluffy"));
        userInfoArrayList.add(new UserInfo("Dave", "dave@mail.com", "yobro"));
        userInfoArrayList.add(new UserInfo("Pat", "pat@mail.com", "dinner"));
        rvAdapter.notifyDataSetChanged();
        return userInfoArrayList;
    }

}
