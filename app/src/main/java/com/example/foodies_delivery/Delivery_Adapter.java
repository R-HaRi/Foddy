package com.example.foodies_delivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Delivery_Adapter extends RecyclerView.Adapter<Delivery_Adapter.MyViewHolder>{
    Context applicationContext;
    ArrayList date;
    ArrayList order_id;
    ArrayList name;
    ArrayList mode;
    ArrayList amount;

    public Delivery_Adapter(Context applicationContext, ArrayList<String> date, ArrayList<String> order_id, ArrayList<String> name, ArrayList<String> mode, ArrayList<String> amount) {
        this.applicationContext = applicationContext;
        this.date = date;
        this.order_id = order_id;
        this.name = name;
        this.mode = mode;
        this.amount = amount;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_deliveries_design,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Date.setText((CharSequence) date.get(position));
        holder.OrderId.setText((CharSequence) order_id.get(position));
        holder.Name.setText((CharSequence) name.get(position));
        holder.Mode.setText((CharSequence) mode.get(position));
        holder.Amount.setText((CharSequence) amount.get(position));

    }



    @Override
    public int getItemCount() {
        return date.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Date;
        TextView OrderId;
        TextView Name;
        TextView Mode;
        TextView Amount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Date = itemView.findViewById(R.id.mydlvr_date);
            OrderId = itemView.findViewById(R.id.mydlvr_ord);
            Name = itemView.findViewById(R.id.mydlvr_cname);
            Mode = itemView.findViewById(R.id.mydlvr_mode);
            Amount = itemView.findViewById(R.id.mydlvr_amount);
        }
    }
}
