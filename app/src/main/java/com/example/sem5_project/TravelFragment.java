package com.example.sem5_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TravelFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ItemModule> list;
    ItemDatabase db;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_garlic, container, false);
        db = new ItemDatabase(requireActivity());
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        list = db.gettravelFromDatabase();

        Log.d("GarlicFragment", "List size: " + list.size());

        AdapterForRecycler adapter =new AdapterForRecycler(requireActivity(),list);
        recyclerView.setAdapter(adapter);

        return view;
    }
}