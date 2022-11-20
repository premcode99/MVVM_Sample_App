package com.example.mvvmsampleapp.ui.auth

import com.example.mvvmsampleapp.data.db.entitise.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user : User)
    fun onFailure(message : String)
}