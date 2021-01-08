package com.example.foodies_delivery.ApiInterfaces;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    String JSON_URL="http://foodies.v2bits.com/";

    @POST("get_orders_status.php")
    @FormUrlEncoded
    Call<String>get_orders_status(@Field("status") String status);

    @POST("update_order_status.php")
    @FormUrlEncoded
    Call<String>update_order_status(@Field("oid") String oid,@Field("status") String status,@Field("info") String info);


}
