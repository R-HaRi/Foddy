package com.example.foodies_delivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActiveAdaptor extends RecyclerView.Adapter<ActiveAdaptor.MyViewHolder> {
    Context context;
    ArrayList name;
    ArrayList order_id;
    ArrayList date;
    ArrayList mode;
    ArrayList amount;


    public ActiveAdaptor(Context context, ArrayList<String> name, ArrayList<String> order_id, ArrayList<String> date, ArrayList<String> mode, ArrayList<String> amount) {
        this.context = context;
        this.name = name;
        this.order_id = order_id;
        this.date = date;
        this.mode = mode;
        this.amount = amount;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.active_orders_design, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Name.setText((CharSequence) name.get(position));
        holder.OrderId.setText((CharSequence) order_id.get(position));
        holder.Date.setText((CharSequence) date.get(position));
        holder.Mode.setText((CharSequence) mode.get(position));
        holder.Amount.setText((CharSequence) amount.get(position));


    }


    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView OrderId;
        TextView Date;
        TextView Mode;
        TextView Amount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.actv_cname);
            OrderId = itemView.findViewById(R.id.actv_ord);
            Date = itemView.findViewById(R.id.actv_date);
            Mode = itemView.findViewById(R.id.actv_mode);
            Amount = itemView.findViewById(R.id.actv_amount);


        }
    }
}
