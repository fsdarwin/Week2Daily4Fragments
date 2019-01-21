package com.example.week2daily4fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    ArrayList<UserInfo> userInfoArrayList;
    public static final String TAG = "FRANK: ";
    CallTask result;

    public RVAdapter(ArrayList<UserInfo> userInfoArrayList) {
        this.userInfoArrayList = userInfoArrayList;
    }

    ViewHolder viewHolder;
    int position;

    @NonNull
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder viewHolder, int position) {

        UserInfo user = userInfoArrayList.get(position);
        if (user != null) {
            String name = user.getUserName();
            String email = user.getUserEmail();
            String pass = user.getUserPass();

            viewHolder.tnName.setText(name);
            viewHolder.tnEmail.setText(email);
            viewHolder.tnPass.setText(pass);
            Log.d(TAG, "onBindViewHolder: " + name);
        }

    }

    public void addUser(UserInfo userInfo) {
        userInfoArrayList.add(userInfo);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        public TextView tnName;
        TextView tnEmail;
        TextView tnPass;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tnName = itemView.findViewById(R.id.tvName);
            tnEmail = itemView.findViewById(R.id.tvEmail);
            tnPass = itemView.findViewById(R.id.tvPass);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: Made it here.");
            String name = tnName.getText().toString();
            result = new CallTask(v, name);
            result.execute(name);
        }

    }

    public int getItemCount() {
        return userInfoArrayList != null ? userInfoArrayList.size() : 0;
    }
    
    public class CallTask extends AsyncTask<String, Integer, Integer> {

        View view;
        String name;
        int result;

        public CallTask(View v, String n) {
            view = v;
            name = n;
        }


        @Override
        protected Integer doInBackground(String... strings) {
            name = strings[0];
            Integer result = name.length();
            return result;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            String message = "Length of " + name + " is " + integer;
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

}
