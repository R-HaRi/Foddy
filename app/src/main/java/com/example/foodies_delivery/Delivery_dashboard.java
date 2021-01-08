package com.example.foodies_delivery;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import static com.example.foodies_delivery.R.string.close_drawer;
import static com.example.foodies_delivery.R.string.open_drawer;

public class Delivery_dashboard extends AppCompatActivity {
    SwitchCompat switchCompat;
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    TabLayout tabLayout;
    String text[] = {"New Orders", "Active Orders"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_dashboard);


        viewPager = findViewById(R.id.dlvr_viewpg);
        tabLayout = findViewById(R.id.dlvr_tab);

        ViewPageAdaptor adaptor = new ViewPageAdaptor(getSupportFragmentManager());
        adaptor.addFragment(new NewOrders());
        adaptor.addFragment(new ActiveOrders());
        viewPager.setAdapter(adaptor);

        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < text.length; i++) {
            tabLayout.getTabAt(i).setText(text[i]);
        }

        // switch

        switchCompat = findViewById(R.id.dlvr_switch);
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String switchcompact1;
                if (switchCompat.isChecked())
                    switchcompact1 = switchCompat.getTextOn().toString();
                else
                    switchcompact1 = switchCompat.getTextOn().toString();
                Intent intent = new Intent(Delivery_dashboard.this, Delivery_offlinePage.class);
                startActivity(intent);

            }
        });


        //bottom navigation
        bottomNavigationView = findViewById(R.id.dlvr_bot_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment fragment = null;
                Intent intent = null;

                switch (id) {

                    case R.id.dlvr_home:
                        break;
                    case R.id.dlvr_mydeliveries:
                        Intent m = new Intent(Delivery_dashboard.this, Delivery_MyDeliveries.class);
                        startActivity(m);
                        break;
                    case R.id.dlvr_profile:
                        Intent p = new Intent(Delivery_dashboard.this, Delivery_Profile.class);
                        startActivity(p);
                        break;
                }
                return true;
            }
        });


    }


}