package com.example.sem5_project;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerModalAdapter extends RecyclerView.Adapter<RecyclerModalAdapter.ViewHolder> {
    Context context;
    ArrayList<Modal>aarrContact;
   RecyclerModalAdapter(Context context, ArrayList<Modal>arrContact){
       this.context=context;
       this.aarrContact=arrContact;
   }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
     }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(aarrContact.get(position).img);
        holder.txtName.setText(aarrContact.get(position).name);
        holder.txtDescription.setText(aarrContact.get(position).description);
    }



    @Override
    public int getItemCount() {
        return aarrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView txtName,txtDescription;
       ImageView imageView;
        public ViewHolder(@NonNull View itemView   ) {
            super(itemView);
            txtName=itemView.findViewById(R.id.name_product);
            txtDescription=itemView.findViewById(R.id.desceription_product);
            imageView=itemView.findViewById(R.id.imgContact);
        }
    }
}
