package com.cliniconnection.cliniconnection;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cliniconnection.cliniconnection.DataBase.ToDoSessions.TodoListItem;


import java.util.List;



public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<TodoListItem> items;

    public UserAdapter(List<TodoListItem> items) {
        this.items = items;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.name.setText(items.get(position).getTitle());
        holder.time.setText(items.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            time= itemView.findViewById(R.id.time);
        }
    }
}