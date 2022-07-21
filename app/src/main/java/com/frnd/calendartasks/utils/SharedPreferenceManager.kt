package com.frnd.calendartasks.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
    ) {

    fun get(key:String)=
        sharedPreferences.getInt(key,-1)

    fun put(key:String,value:Int){
        sharedPreferences.edit().putInt(key,value).apply()
    }

}