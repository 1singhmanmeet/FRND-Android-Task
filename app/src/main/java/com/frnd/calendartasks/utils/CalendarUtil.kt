package com.frnd.calendartasks.utils

import android.util.Log
import com.frnd.calendartasks.data.models.CalenderDataItem
import java.util.*

class CalendarUtil {

    private val months= arrayOf(
        "January", "February", "March", "April",
        "May", "June", "July", "August",
        "September", "October", "November", "December"
    )

    private val weekDays= arrayOf(
        "","Sun","Mon","Tue","Wed","Thu","Fri","Sat"
    )

    fun getCurrentMonth():String{
        calendar=Calendar.getInstance()
        return months[calendar.get(Calendar.MONTH)]
    }

    fun getCurrentYear():Int{
        calendar=Calendar.getInstance()
        return calendar.get(Calendar.YEAR)
    }

    fun getCurrentDate():Date{
        calendar=Calendar.getInstance()
        return calendar.time
    }

    fun getNextMonth(month:String):String{
        try {
            var pos=months.indexOf(month)
            return if(pos==11)
                months[0]
            else
                months[++pos]
        }catch (e:Exception){
            e.printStackTrace()
            Log.e("CalendarUtil","Please provide valid month")
        }
        return ""
    }

    fun getPreviousMonth(month:String):String{
        try {
            var pos=months.indexOf(month)
            return if(pos==0)
                months[11]
            else
                months[--pos]
        }catch (e:Exception){
            e.printStackTrace()
            Log.e("CalendarUtil","Please provide valid month")
        }
        return ""
    }

    fun getDaysList(month:String,year:Int):List<CalenderDataItem>{
        val daysList=ArrayList<CalenderDataItem>()

        try {
            // get today date
            val date=getCurrentDate()
            calendar.time=date
            val currentDay= calendar.get(Calendar.DAY_OF_MONTH)
            val currentMonth= calendar.get(Calendar.MONTH)
            val currentYear= calendar.get(Calendar.YEAR)

            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,months.indexOf(month))
            val daysInMonth=calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            var day=1
            calendar.set(Calendar.DAY_OF_MONTH,day)

            var getDayOfWeek= weekDays[calendar.get(Calendar.DAY_OF_WEEK)]
            for(i in 0 until daysInMonth){

                daysList.add(
                    CalenderDataItem(
                        calendar.time,
                        day,
                        getDayOfWeek,
                        0,
                        (currentDay==day && currentYear==calendar.get(Calendar.YEAR)
                                && currentMonth== calendar.get(Calendar.MONTH))
                    )
                )
                day++
                calendar.set(Calendar.DAY_OF_MONTH,day)
                getDayOfWeek= weekDays[calendar.get(Calendar.DAY_OF_WEEK)]

            }
        }catch (e:Exception){
            e.printStackTrace()
            Log.e("CalendarUtil","Please check input param format")
        }
        return daysList
    }

    companion object{
        private var instance:CalendarUtil?=null
        private var calendar=Calendar.getInstance()

        fun getInstance():CalendarUtil{
            if(instance==null)
                instance= CalendarUtil()
            return instance!!
        }
    }
}