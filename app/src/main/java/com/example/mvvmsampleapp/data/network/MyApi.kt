package com.example.mvvmsampleapp.data.network

import com.example.mvvmsampleapp.data.network.responses.AuthResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(  //A suspend function is simply a function that can be paused and resumed at a later time
        //so these type of function can execute a long running operation and wait without
        @Field("email")email : String,
        @Field("password")password : String,
    ) : Response<AuthResponse>

   //suspend function userLogin should be called only from a coroutine or another suspend functions
    companion object {
        operator fun invoke() : MyApi{
            val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}