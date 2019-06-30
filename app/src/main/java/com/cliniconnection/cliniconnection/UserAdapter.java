package com.cliniconnection.cliniconnection;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    //ArrayList<String> users;

    /*public UserAdapter(ArrayList<String> users) {
        this.users = users;
    }*/

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //2 rows to be deleted
        //View view = LayoutInflater .from(parent.getContext()).inflate(R.layout.users_row, parent, false);
        //return new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
       // holder.firstname.setText(users.get(position));

    }

    @Override
    public int getItemCount() {
        return 0;
        //return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //public TextView firstname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //firstname = itemView.findViewById(R.id.firstname);

        }
    }
}
