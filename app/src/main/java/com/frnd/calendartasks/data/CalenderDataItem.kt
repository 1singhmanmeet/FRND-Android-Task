package com.frnd.calendartasks.data

import java.util.*

data class CalenderDataItem(
    val date:Date,
    val dayOfMonth:Int,
    val dayOfWeek:String="",
    var taskCount:Int=0,
    var isToday:Boolean=false
)