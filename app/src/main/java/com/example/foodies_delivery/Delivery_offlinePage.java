package com.example.foodies_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class Delivery_offlinePage extends AppCompatActivity {
    LottieAnimationView animationView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_offline_page);

        button = findViewById(R.id.dlvr_oflb);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Delivery_offlinePage.this,Delivery_dashboard.class);
                startActivity(intent);
            }
        });


        // Declaring the animation view
         animationView = findViewById(R.id.dlvr_lottie);
        animationView.addAnimatorUpdateListener(
                        (animation) -> {
                            // Do something.
                        });
        animationView.playAnimation();

        if (animationView.isAnimating()) {
            // Do something.
        }

    }
}