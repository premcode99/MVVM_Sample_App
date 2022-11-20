package com.example.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmsampleapp.data.repositories.UserRepository
import com.example.mvvmsampleapp.util.Coroutines

class AuthViewModel : ViewModel() {

    var email : String? = null
    var password : String? = null

    var authListener : AuthListener? = null

    fun onLoginButtonClicked(view : View){
        authListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid Email and Password")
            return
        }
        Coroutines.main {
            val loginResponse = UserRepository().userLogin(email!!, password!!)
            if(loginResponse.isSuccessful)
                authListener?.onSuccess(loginResponse.body()?.user!!)
            else
                authListener?.onFailure("Error code : ${loginResponse.code()}")

        }


    }

}