package com.example.exercise_for_interview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>  {
    List<Hero> heroes;
    public DataAdapter(ArrayList<Hero> arrayList) {
this.heroes=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
View view=layoutInflater.inflate(R.layout.list_item,parent,false);
ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.userid.setText(heroes.get(position).getUserId());
        holder.id.setText(heroes.get(position).getId());
        holder.title.setText(heroes.get(position).getTitle());
        holder.body.setText(heroes.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
TextView userid,id,title,body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
userid=itemView.findViewById(R.id.userid);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }
}
