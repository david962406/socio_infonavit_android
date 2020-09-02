package com.skimy.infonavit.data.network;

import com.skimy.infonavit.data.models.LandingResponse;
import com.skimy.infonavit.data.models.userClass;
import com.skimy.infonavit.data.models.userjson;
import com.skimy.infonavit.data.models.walletClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIService {

    @POST("login")
    Call<userClass> login_infonavit(@Body userjson user);
    @GET("member/wallets")
    Call<ArrayList<walletClass>> getwallets();
    @GET("member/landing_benevits")
    Call<LandingResponse> getBenevits(@Header("Authorization")String token);
    @DELETE("logout")
    Call<Response<String>> logout();


}

