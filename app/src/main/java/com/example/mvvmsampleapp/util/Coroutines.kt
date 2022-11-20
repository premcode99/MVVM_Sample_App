package com.example.mvvmsampleapp.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//we will define as object so we can user this class to directly call the functions
//object is similar to static in java

object Coroutines {

    fun main(work : suspend(() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {//launch return a job
        work()
    }
}