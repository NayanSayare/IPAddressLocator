package com.example.najo.ipaddresslocator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LocatorApi {

    @GET("?ip={address}&auth=e6a4fbf7-dab2-42b1-889d-5741025caa57")
    Call<IPAddressLocator> getLocation(@Path("address") String address) ;

}
