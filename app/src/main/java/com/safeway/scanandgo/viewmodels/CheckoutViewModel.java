package com.safeway.scanandgo.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.safeway.scanandgo.services.models.CartResponse;
import com.safeway.scanandgo.services.repositories.network.ScanAndGoApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CheckoutViewModel extends ViewModel {

    private MutableLiveData<CartResponse> cartResponse;

    public LiveData<CartResponse> getCart() {

        if (cartResponse == null) {
            cartResponse = new MutableLiveData<>();
            loadCartResponse();
        }

        return cartResponse;
    }

    private void loadCartResponse() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("user_id", "0001231231232")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ScanAndGoApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final ScanAndGoApi api = retrofit.create(ScanAndGoApi.class);
        final Call<CartResponse> call = api.getCart();

        /*call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(@NonNull Call<CartResponse> call, @NonNull retrofit2.Response<CartResponse> response) {
                cartResponse.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<CartResponse> call, @NonNull Throwable t) {
                System.err.println("error");
            }
        });*/
    }
}
