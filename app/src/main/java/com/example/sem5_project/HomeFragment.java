package com.example.sem5_project;

import android.nfc.NfcAntennaInfo;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    CardView card_travel,card_food,card_ecommerce,card_mobile,card_health,card_fitness;
    RecyclerView recyclerView;
    ArrayList<Modal>arrModel=new ArrayList<Modal>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.popular_product);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        arrModel.add(new Modal(R.drawable.amazon,"amazon","desciption"));
        arrModel.add(new Modal(R.drawable.flipkart,"Flipkart","desciption"));
        arrModel.add(new Modal(R.drawable.shopsy,"shopsy","desciption"));
        arrModel.add(new Modal(R.drawable.adidas,"adidas","desciption"));
        arrModel.add(new Modal(R.drawable.meesho,"meesho","desciption"));
        arrModel.add(new Modal(R.drawable.bgmi,"bgmi","desciption"));
        arrModel.add(new Modal(R.drawable.starbucks,"starbucks","desciption"));
        RecyclerModalAdapter adapter=new RecyclerModalAdapter(getContext(),arrModel);
        recyclerView.setAdapter(adapter);



        card_travel = view.findViewById(R.id.travel);
        card_travel.setOnClickListener(v -> {

            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container,new TravelFragment());
            ft.addToBackStack(null);
            ft.commit();
        });
        card_food = view.findViewById(R.id.food);
        card_food.setOnClickListener(v -> {

            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container,new FoodFragment());
            ft.addToBackStack(null);
            ft.commit();
        });
        card_ecommerce = view.findViewById(R.id.ecommerce);
        card_ecommerce.setOnClickListener(v -> {

            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container,new EcommerceFragment());
            ft.addToBackStack(null);
            ft.commit();
        });
        card_mobile = view.findViewById(R.id.mobile);
        card_mobile.setOnClickListener(v -> {

            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container,new MobileFragment());
            ft.addToBackStack(null);
            ft.commit();
        });
        card_health = view.findViewById(R.id.health);
        card_health.setOnClickListener(v -> {

            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container,new HealthFragment());
            ft.addToBackStack(null);
            ft.commit();
        });
        card_fitness = view.findViewById(R.id.fitness);
        card_fitness.setOnClickListener(v -> {

            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container,new FitnessFragment());
            ft.addToBackStack(null);
            ft.commit();
        });

        return view;
    }
}