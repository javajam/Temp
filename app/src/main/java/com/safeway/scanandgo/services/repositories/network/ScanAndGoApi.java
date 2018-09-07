package com.safeway.scanandgo.services.repositories.network;

import com.safeway.scanandgo.services.models.CartResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScanAndGoApi {

    String BASE_URL = "https://scanandgonew.azurewebsites.net/api/";

    @GET("viewCart")
    Call<CartResponse> getCart();
}
