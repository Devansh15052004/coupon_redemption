package com.example.sem5_project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForRecycler extends RecyclerView.Adapter<AdapterForRecycler.ViewHold> {

    Context context;
    ArrayList<ItemModule> list;

    public AdapterForRecycler(Context context,ArrayList<ItemModule>list){
        this.context = context;
        this.list = list;
        if(list == null){
            Log.d("Adapter","List is Empty");
        }
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemlayout,parent,false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {

        ItemModule data =list.get(position);
        holder.category.setText(data.category);
        holder.discount.setText(data.discount);
        holder.description.setText(data.description);
        holder.name.setText(data.name);
        holder.coupontype.setText(data.coupontype);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {

        TextView category,discount,name,description,coupontype;
        public ViewHold(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category);
            name = itemView.findViewById(R.id.name);
            discount = itemView.findViewById(R.id.discount);
            description = itemView.findViewById(R.id.description);
            coupontype = itemView.findViewById(R.id.coupontype);
        }
    }
}