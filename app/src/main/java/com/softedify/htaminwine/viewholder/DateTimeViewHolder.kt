package com.softedify.htaminwine.viewholder

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.softedify.htaminwine.R
import com.softedify.htaminwine.data.vos.DateVO
import com.softedify.htaminwine.delegate.DateDelegate

class DateTimeViewHolder(itemView: View, val mDelegate: DateDelegate) :
    RecyclerView.ViewHolder(itemView) {
    lateinit var date: TextView
    lateinit var day: TextView

    init {
        date = itemView.findViewById(R.id.tvDate)
        day = itemView.findViewById(R.id.tvDay)
    }

    fun bindData(dateVO: DateVO) {
        itemView.setOnClickListener {
            mDelegate.onTapDate(dateVO.date)
        }
        date.text = dateVO.day
        day.text = dateVO.weekDay

        if (dateVO.isSelected) {
            itemView.findViewById<TextView>(R.id.tvDay).setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    R.color.white
                )
            )

            itemView.findViewById<LinearLayout>(R.id.llDateTime).setBackgroundResource(
                R.drawable.ripple
            )

        } else {
            itemView.findViewById<TextView>(R.id.tvDay).setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    R.color.black
                )
            )
            itemView.findViewById<LinearLayout>(R.id.llDateTime).setBackgroundColor(
                ContextCompat.getColor(
                    itemView.context,
                    R.color.white
                )
            )

        }
    }
}