package com.example.mvvmsampleapp.data.network.responses

import com.example.mvvmsampleapp.data.db.entitise.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message : String?,
    val user : User?    
)