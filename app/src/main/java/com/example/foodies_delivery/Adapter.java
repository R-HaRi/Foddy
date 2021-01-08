
package com.example.foodies_delivery;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodies_delivery.Models.GetOrderStatusModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    ArrayList<GetOrderStatusModel> retromodelarraylist;


    public Adapter(ArrayList<GetOrderStatusModel> retromodelarraylist, Context context) {
        this.context = context;
        this.retromodelarraylist = retromodelarraylist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_orders_design, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Name.setText(retromodelarraylist.get(position).getName());
        holder.OrderId.setText(retromodelarraylist.get(position).getOid());
        holder.Date.setText(retromodelarraylist.get(position).getCreatedOn());
        holder.Mode.setText(retromodelarraylist.get(position).getPayment_status());
        holder.Amount.setText(retromodelarraylist.get(position).getAmount());
        holder.Resort_address.setText(retromodelarraylist.get(position).getBusiness_address());
        holder.User_address.setText(retromodelarraylist.get(position).getDelivery());


    }


    @Override
    public int getItemCount() {
        return retromodelarraylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView OrderId;
        TextView Date;
        TextView Mode;
        TextView Amount;
        TextView Resort_address;
        TextView User_address;
        TextInputLayout Info;
        Button Reject;
        Button Accept;
        CardView CardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.newOrd_cname);
            OrderId = itemView.findViewById(R.id.newOrd_Ord);
            Date = itemView.findViewById(R.id.newOrd_date);
            Mode = itemView.findViewById(R.id.newOrd_mode);
            Amount = itemView.findViewById(R.id.newOrd_amount);
            Resort_address = itemView.findViewById(R.id.newOrd_resort_add);
            User_address = itemView.findViewById(R.id.newOrd_user_add);
            CardView = itemView.findViewById(R.id.newOrd_card);
            Accept = itemView.findViewById(R.id.dlvr_button1);

            Accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (CardView.getVisibility() == View.VISIBLE)
                        CardView.setVisibility(View.GONE);
                    else
                        CardView.setVisibility(View.VISIBLE);
                    Toasty.success(context,"You accepted the order",Toast.LENGTH_SHORT,true).show();

//                    Toast.makeText(context, "You accepted the order", Toast.LENGTH_SHORT).show();
                }
            });


            Reject = itemView.findViewById(R.id.dlvr_button2);
            Reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCustomDailog();

                }

                private void showCustomDailog() {
                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.delivery_dialog);
                    dialog.setCancelable(true);
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

                    TextInputEditText text = dialog.findViewById(R.id.rjct_text1);
                    Button cancel = dialog.findViewById(R.id.rjct_button1);
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    Button submit = dialog.findViewById(R.id.rjct_button2);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String reasons = text.getText().toString().trim();
                            if (reasons.isEmpty()) {
                                Toasty.info(context,"please provide the reasons of declining",Toast.LENGTH_SHORT,true).show();
                            }
                            dialog.dismiss();
                            Toasty.error(context, "You declined the order", Toast.LENGTH_SHORT,true).show();
                            if (CardView.getVisibility() == View.VISIBLE)
                                CardView.setVisibility(View.GONE);
                            else
                                CardView.setVisibility(View.VISIBLE);
                        }
                    });
                    dialog.show();

                }
            });

        }
    }


}

