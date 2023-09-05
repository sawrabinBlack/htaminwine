package com.softedify.htaminwine.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.softedify.htaminwine.R
import com.softedify.htaminwine.adapters.DateTimeAdapter
import com.softedify.htaminwine.data.models.HtaminWineModel
import com.softedify.htaminwine.data.models.HtaminWineModelImpl
import com.softedify.htaminwine.data.vos.DailyRecordVO
import com.softedify.htaminwine.data.vos.DateVO
import com.softedify.htaminwine.delegate.DateDelegate
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class History : AppCompatActivity(), DateDelegate {

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,History::class.java)
        }
    }
    lateinit var dataTimeRecyclerView: RecyclerView
    lateinit var mAdapter: DateTimeAdapter
    lateinit var calorieText: TextView
    lateinit var carbsText: TextView
    lateinit var proteinText : TextView
    lateinit var fatText: TextView
    lateinit var workoutText: TextView
    lateinit var waterText: TextView
    val mModel: HtaminWineModel = HtaminWineModelImpl
    var dateList: List<DateVO> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
       calorieText = findViewById(R.id.tvCalorieHistory)
       carbsText = findViewById(R.id.tvCarbsHistory)
        proteinText = findViewById(R.id.tvProteinHistory)
        fatText = findViewById(R.id.tvFatHistory)
        workoutText = findViewById(R.id.tvWorkOutHistory)
        waterText = findViewById(R.id.tvWaterHistory)
        dataTimeRecyclerView = findViewById(R.id.rvDateTime)
        mAdapter = DateTimeAdapter(this)
        dataTimeRecyclerView.adapter = mAdapter
        dataTimeRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val twoWeeksData = mutableListOf<DateVO>()
        for (day in 0 downTo -7) {
            val c1 = Calendar.getInstance()
            c1.add(Calendar.DATE, day)
            val time = c1.time
            val day1 = SimpleDateFormat("EEE", Locale.ENGLISH).format(time)
            val date = SimpleDateFormat("dd", Locale.ENGLISH).format(time)
            val dateFull = SimpleDateFormat("ddMMyy", Locale.ENGLISH).format(time)
            twoWeeksData.add(
                DateVO(
                    day = date, weekDay = day1, date = dateFull
                )
            )


        }

        dateList = twoWeeksData.reversed()
        mAdapter.setNewData(dateList)
        dataTimeRecyclerView.scrollToPosition(mAdapter.itemCount - 1)
        onTapDate(twoWeeksData.first().date)
    }

    override fun onTapDate(date: String) {
        if(mModel.getDailyRecordByDateOneTime(date) == null) {
            updateData(DailyRecordVO(date))
        }
        mModel.getDailyRecordByDateOneTime(date)?.let {
            updateData(it)
        }
        for (d in dateList){
            d.isSelected = d.date == date
        }
        Log.d("date",date)
        Log.d("date", dateList.toString())
        mAdapter.setNewData(dateList)
    }

    fun updateData(dailyRecord: DailyRecordVO) {
        calorieText.text = "${dailyRecord.calories} kCal"
        proteinText.text = "${dailyRecord.protein} g"
        carbsText.text = " ${dailyRecord.carbos} g"
        fatText.text = "${dailyRecord.fat} g"
        waterText.text = "${dailyRecord.water} ml"
        workoutText.text = "${dailyRecord.workout} mins"
    }

}