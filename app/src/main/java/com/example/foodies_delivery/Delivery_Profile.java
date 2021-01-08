package com.example.foodies_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Delivery_Profile extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    RelativeLayout relativeLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery__profile);
        imageView = findViewById(R.id.dlvr_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Delivery_Profile.this,Delivery_dashboard.class);
                startActivity(i);
            }
        });
        textView = findViewById(R.id.dlvr_logout);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Delivery_Profile.this,Delivery_dashboard.class);
                startActivity(i);
            }
        });
        relativeLayout1 = findViewById(R.id.dlvr_mydeliveries);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Delivery_Profile.this,Delivery_MyDeliveries.class);
                startActivity(i);
            }
        });
    }
}