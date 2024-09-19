package com.example.sem5_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddFragment extends Fragment {
TextView cat;
    EditText name,type,price,location,time;
    Button btn;
    ItemDatabase db;
    String[]category={"Travel","Foods","Ecommerce","Mobile","Health","Fitness"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String>adapterItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);
        final String[] item = new String[1];
        name = view.findViewById(R.id.name);
        type = view.findViewById(R.id.type);
        cat=view.findViewById(R.id.cat);
        autoCompleteTextView=view.findViewById(R.id.autocompletetext);
        adapterItem=new ArrayAdapter<String>(requireActivity(),R.layout.categorylist,category);
        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item[0] =adapterView.getItemAtPosition(i).toString();
                cat.setText(item[0]);
            }
        });
        location = view.findViewById(R.id.location);
        time = view.findViewById(R.id.time);
        btn = view.findViewById(R.id.btn);
        db = new ItemDatabase(requireActivity());

        btn.setOnClickListener(v -> {
            String n = name.getText().toString();
            String dis = type.getText().toString().toUpperCase();
            String cat = item[0];
            String des = location.getText().toString();
            String co = time.getText().toString();

            if (n.isEmpty() || dis.isEmpty() || cat.isEmpty() || des.isEmpty() || co.isEmpty()) {
                Toast.makeText(requireActivity(), "Enter all details", Toast.LENGTH_SHORT).show();
            } else {

                ItemModule data = new ItemModule(cat, n, dis, des, co);
                db.addItemToDatabase(data);
                Toast.makeText(requireActivity(), cat + "coupon added", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}