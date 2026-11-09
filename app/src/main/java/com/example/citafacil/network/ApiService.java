
package com.example.citafacil.network;

import com.example.citafacil.model.LoginRequest;
import com.example.citafacil.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("api/usuarios/login")
    Call<LoginResponse> iniciarSesion(
            @Body LoginRequest request
    );

}
