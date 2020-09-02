package com.skimy.infonavit.data.network;

import android.util.Log;

import com.skimy.infonavit.data.models.walletClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class dataRepository {
    public Retrofit retrofit= retrofitClient.getClient();
    public APIService api=retrofit.create(APIService.class);

    public ArrayList<walletClass>getWallets(){
        ArrayList<walletClass> wallets=new ArrayList<>();
        Call<ArrayList<walletClass>> call=api.getwallets();
        call.enqueue(new Callback<ArrayList<walletClass>>() {

            @Override
            public void onResponse(Call<ArrayList<walletClass>> call, Response<ArrayList<walletClass>> response) {
                Log.d("test","no tas registrao chao");
                wallets.addAll(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<walletClass>> call, Throwable t) {
                Log.d("test",t.toString());
            }
        });
        return wallets;
    }



}
