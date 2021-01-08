package com.example.foodies_delivery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodies_delivery.ApiInterfaces.ApiInterface;
import com.example.foodies_delivery.Models.GetOrderStatusModel;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class NewOrders extends Fragment {
    RecyclerView recyclerView;
    View view;
    String Base_url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_new_orders, container, false);
        recyclerView = view.findViewById(R.id.dlvr_recview1);

        getOrders();
        return view;
    }

    private void getOrders() {
        Base_url = ApiInterface.JSON_URL;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiInterface interfaces = retrofit.create(ApiInterface.class);
        Call<String> call = interfaces.get_orders_status("ordered");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    if (response != null) {
                        Log.i("retrofit_response", response.body().toString());
                        String jsonresponse = response.body().toString();
                        writeTv(jsonresponse);
                    } else {
                        Log.i("retrofit_response", "Return empty response");
                    }
                }
            }


            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("retrofit_response", "Failed in retrofit");
            }
        });
    }

    private void writeTv(String jsonresponse) {
        try {
            JSONObject obj = new JSONObject(jsonresponse);
            if (obj.optString("status").equalsIgnoreCase("true")) {
                ArrayList<GetOrderStatusModel> getOrderStatusModels = new ArrayList<>();
                JSONArray dataarray = obj.getJSONArray("data");
                for (int i = 0; i < dataarray.length(); i++) {
                    GetOrderStatusModel orderStatusModel = new GetOrderStatusModel();
                    JSONObject dataobj = dataarray.getJSONObject(i);
                    orderStatusModel.setName(dataobj.getString("name"));
                    orderStatusModel.setOid(dataobj.getString("oid"));
                    orderStatusModel.setUid(dataobj.getString("uid"));
                    orderStatusModel.setDbid(dataobj.getString("dbid"));
                    orderStatusModel.setAmount(dataobj.getString("amount"));
                    orderStatusModel.setDelivery(dataobj.getString("delivery"));
                    orderStatusModel.setStatus(dataobj.getString("status"));
                    orderStatusModel.setPayment_status(dataobj.getString("payment_status"));
                    orderStatusModel.setBusiness_address(dataobj.getString("business_address"));
                    orderStatusModel.setInfo(dataobj.getString("info"));
                    orderStatusModel.setCreatedOn(dataobj.getString("createdOn"));
                    getOrderStatusModels.add(orderStatusModel);
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);
                Adapter adapter = new Adapter(getOrderStatusModels, getContext());
                recyclerView.setAdapter(adapter);

            } else if (obj.optString("status").equalsIgnoreCase("false")) {
                Toast.makeText(getContext(), "There is no orders upto now", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            Log.i("checking status", e.toString());
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}




