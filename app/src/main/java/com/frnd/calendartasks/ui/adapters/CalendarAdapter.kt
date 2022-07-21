package com.frnd.calendartasks.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.frnd.calendartasks.databinding.CalenderDataItemBinding
import com.frnd.calendartasks.data.models.CalenderDataItem

class CalendarAdapter:ListAdapter<CalenderDataItem,
        CalendarAdapter.CalendarItemHolder>(CalendarDiff()){
    class CalendarItemHolder(val binding:CalenderDataItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(calendarItem: CalenderDataItem){
            binding.day.text=calendarItem.dayOfMonth.toString()
            binding.indicator.visibility= View.VISIBLE
            binding.weekDay.text=calendarItem.dayOfWeek
            binding.currentDay.apply {
                visibility = if(calendarItem.isToday)
                    View.VISIBLE
                else
                    View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        CalendarItemHolder(
            CalenderDataItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )

    override fun onBindViewHolder(holder: CalendarItemHolder, position: Int) {
        holder.bind(getItem(holder.bindingAdapterPosition))
    }

    class CalendarDiff:DiffUtil.ItemCallback<CalenderDataItem>(){
        override fun areItemsTheSame(
            oldItem: CalenderDataItem,
            newItem: CalenderDataItem
        ): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: CalenderDataItem,
            newItem: CalenderDataItem
        ): Boolean {
            return oldItem==newItem
        }

    }
}