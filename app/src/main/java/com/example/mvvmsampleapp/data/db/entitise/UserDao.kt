package com.example.mvvmsampleapp.data.db.entitise

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    /*Here we will insert user detail in case of conflict we will replace*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user : User ) : Long

    /*In case if we want to get save user detail the we will create Query*/

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>
}