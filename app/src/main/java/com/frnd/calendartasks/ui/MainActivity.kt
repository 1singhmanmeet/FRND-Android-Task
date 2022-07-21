package com.frnd.calendartasks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.frnd.calendartasks.R
import com.frnd.calendartasks.ui.adapters.CalendarAdapter
import com.frnd.calendartasks.utils.CalendarUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendar_recycler?.layoutManager = GridLayoutManager(this, 7)
        val calAdapter = CalendarAdapter()
        calendar_recycler?.adapter = calAdapter
        val cal = CalendarUtil.getInstance()
        val list = cal.getDaysList(
            cal.getCurrentMonth(), cal.getCurrentYear()
        )
        calAdapter.submitList(list)

    }
}