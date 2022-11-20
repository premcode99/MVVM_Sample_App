package com.example.mvvmsampleapp.data.db.entitise

import androidx.room.Entity
import androidx.room.PrimaryKey

//define currentUserId
const val CURRENT_USER_ID  = 0

@Entity
data class User(
    var id : Int? =  null,
    var name : String? =  null,
    var email : String? =  null,
    var password : String? = null,
    var email_varified_at : String? = null,
    var createdat : String? = null,
    var updated_at : String? = null,
){
    @PrimaryKey(autoGenerate = false)
    var uid : Int  = CURRENT_USER_ID
}

//to handle the database for the user we need to create DAO data access object