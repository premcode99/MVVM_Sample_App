package com.example.mvvmsampleapp.data.repositories

import com.example.mvvmsampleapp.data.network.MyApi
import com.example.mvvmsampleapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository{

    suspend fun userLogin(email : String , password : String) : Response<AuthResponse>{
        return MyApi().userLogin(email, password)
    }
}