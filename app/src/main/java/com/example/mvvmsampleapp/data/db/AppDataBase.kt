package com.example.mvvmsampleapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmsampleapp.data.db.entitise.User
import com.example.mvvmsampleapp.data.db.entitise.UserDao

//save all entities in class and add in array
@Database(
    entities = [User ::class],
    version = 1 //version of our database
)

abstract class AppDataBase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

    companion object {

        @Volatile //this variable immediately means this will be visible to all the other threads
        private var instance : AppDataBase? = null
        private val LOCK = Any() // this means we do able to create two instances of our database

        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){
            instance?: buildDatabase(context).also {
                instance = it
            }

        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            "MyDatabase.db")
            .build()
    }
}