package com.example.foodies_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Delivery_MyDeliveries extends AppCompatActivity {
    ImageView imageView;
    RecyclerView recyclerView;


    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> order_id = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> mode = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery__my_deliveries);
        imageView = findViewById(R.id.dlvr_back1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Delivery_MyDeliveries.this,Delivery_dashboard.class);
                startActivity(i);

            }
        });

        recyclerView = findViewById(R.id.dlvr_recview3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        Delivery_Adapter adapter = new Delivery_Adapter(getApplicationContext(),date,order_id,name,mode,amount);
        recyclerView.setAdapter(adapter);

        date.add("06-01-2021");
        date.add("06-01-2021");
        date.add("06-01-2021");
        date.add("06-01-2021");
        date.add("06-01-2021");

        order_id.add("#0123456");
        order_id.add("#0123456");
        order_id.add("#0123456");
        order_id.add("#0123456");
        order_id.add("#0123456");

        name.add("Hari");
        name.add("Hari");
        name.add("Hari");
        name.add("Hari");
        name.add("Hari");

        mode.add("cod");
        mode.add("cod");
        mode.add("cod");
        mode.add("cod");
        mode.add("cod");

        amount.add("Rs 340");
        amount.add("Rs 340");
        amount.add("Rs 340");
        amount.add("Rs 340");
        amount.add("Rs 340");
    }
}