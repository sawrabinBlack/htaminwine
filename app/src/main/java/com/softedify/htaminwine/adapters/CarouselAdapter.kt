package com.softedify.htaminwine.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderView
import com.smarteist.autoimageslider.SliderViewAdapter
import com.softedify.htaminwine.R

class CarouselAdapter :  SliderViewAdapter<CarouselAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {


    }

    override fun getCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.view_holder_ads_banner, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {

    }
}