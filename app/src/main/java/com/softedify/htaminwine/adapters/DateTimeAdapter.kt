package com.softedify.htaminwine.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softedify.htaminwine.R
import com.softedify.htaminwine.data.vos.DateVO
import com.softedify.htaminwine.delegate.DateDelegate
import com.softedify.htaminwine.viewholder.DateTimeViewHolder
import java.util.Date

class DateTimeAdapter(val mDelegate: DateDelegate): RecyclerView.Adapter<DateTimeViewHolder>() {
    var mList : List<DateVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateTimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_date_time,parent,false)
        return  DateTimeViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: DateTimeViewHolder, position: Int) {

        if (mList.isNotEmpty()){
            holder.bindData(mList[position])
        }

    }

    override fun getItemCount(): Int {
        return mList.count()
    }

    fun setNewData(dateList : List<DateVO>){
        mList = dateList
        notifyDataSetChanged()
    }
}