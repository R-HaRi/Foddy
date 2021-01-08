package com.example.foodies_delivery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ActiveOrders extends Fragment {
    RecyclerView recyclerView;
    View view;

    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> order_id = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> mode = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_active_orders, container, false);

        /// recycler view
        recyclerView = view.findViewById(R.id.dlvr_recview2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ActiveAdaptor adaptor = new ActiveAdaptor(getContext(),name,order_id,date,mode,amount);
        recyclerView.setAdapter(adaptor);

        name.add("Hari");
        name.add("Hari");
        name.add("Hari");
        name.add("Hari");
        name.add("Hari");

        order_id.add("#01234567");
        order_id.add("#01234567");
        order_id.add("#01234567");
        order_id.add("#01234567");
        order_id.add("#01234567");

        date.add("01-01-2021");
        date.add("01-01-2021");
        date.add("01-01-2021");
        date.add("01-01-2021");
        date.add("01-01-2021");

        mode.add("code");
        mode.add("code");
        mode.add("code");
        mode.add("code");
        mode.add("code");

        amount.add("300");
        amount.add("300");
        amount.add("300");
        amount.add("300");
        amount.add("300");


        return view;
    }
}