package com.softedify.htaminwine.activities

import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.smarteist.autoimageslider.SliderView
import com.softedify.htaminwine.R
import com.softedify.htaminwine.adapters.CarouselAdapter
import com.softedify.htaminwine.adapters.MealAdapter
import com.softedify.htaminwine.adapters.MealIngredientsAdapter
import com.softedify.htaminwine.data.models.HtaminWineModel
import com.softedify.htaminwine.data.models.HtaminWineModelImpl
import com.softedify.htaminwine.delegate.MealDelegate
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), MealDelegate {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    var mModel: HtaminWineModel = HtaminWineModelImpl
    lateinit var mealIngredientsAdapter: MealIngredientsAdapter
    lateinit var carouselAdapter: CarouselAdapter
    lateinit var mMealAdapter: MealAdapter
    lateinit var mMealItemAdapter: MealAdapter
    lateinit var mealBottomSheet: BottomSheetDialog
    lateinit var mealItemBottomSheet: BottomSheetDialog
    lateinit var mealDetailbottomsheet: BottomSheetDialog
    var waterCup1: RelativeLayout? = null
    var waterCup2: RelativeLayout? = null
    var waterCup3: RelativeLayout? = null
    var workout1: RelativeLayout? = null
    var workout2: RelativeLayout? = null
    var workout3: RelativeLayout? = null
    var workout4: RelativeLayout? = null
    lateinit var calorieText: TextView
    lateinit var waterText: TextView
    lateinit var workoutText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c1 = Calendar.getInstance()
        val time = c1.time
        val date = SimpleDateFormat("ddMMyy", Locale.ENGLISH).format(time)
        mealDetailbottomsheet = BottomSheetDialog(this)
        val workoutBottomSheet = BottomSheetDialog(this)
        val waterBottomSheet = BottomSheetDialog(this)
        mealBottomSheet = BottomSheetDialog(this)
        mealItemBottomSheet = BottomSheetDialog(this)
        mealBottomSheet.setContentView(R.layout.bottom_sheet_food_category)
        mealDetailbottomsheet.setContentView(R.layout.bottom_sheet_food)
        waterBottomSheet.setContentView(R.layout.bottom_sheet_water)
        workoutBottomSheet.setContentView(R.layout.bottom_sheet_work_out)
        mealItemBottomSheet.setContentView(R.layout.bottom_sheet_food_items)
        waterCup1 = waterBottomSheet.findViewById(R.id.rlFirstWaterCup)
        waterCup2 = waterBottomSheet.findViewById(R.id.rlWaterCup2)
        waterCup3 = waterBottomSheet.findViewById(R.id.rlWaterCup3)
        workout1 = workoutBottomSheet.findViewById(R.id.rlWorkOut1)
        workout2 = workoutBottomSheet.findViewById(R.id.rlWorkOut2)
        workout3 = workoutBottomSheet.findViewById(R.id.rlWorkOut3)
        workout4 = workoutBottomSheet.findViewById(R.id.rlWorkOut4)
        calorieText = findViewById(R.id.tvTotalCalorie)
        waterText = findViewById(R.id.tvWaterAmount)
        workoutText = findViewById(R.id.tvWorkOut)
        val fabMeal: FloatingActionButton = findViewById(R.id.fabNewMeal)
        val fabWorkOut: FloatingActionButton = findViewById(R.id.fabNewWorkOut)
        val fabWater: FloatingActionButton = findViewById(R.id.fabNewWater)
        val profilePhoto: CardView = findViewById(R.id.cvProfilePhotoMain)
mModel.createNewDailyRecord(date)
        mModel.getDailyRecordByDate(date)?.observe(this) {
            calorieText.text = "${it?.calories?:0}"
            waterText.text = "${it?.water?:0}"
            workoutText.text = it?.workout.toString()
        }
        waterCup1?.setOnClickListener {
            mModel.updateWater(100, date)
            waterBottomSheet.dismiss()
        }

        waterCup2?.setOnClickListener {
            mModel.updateWater(100, date)
            waterBottomSheet.dismiss()
        }

        waterCup3?.setOnClickListener {
            mModel.updateWater(100, date)
            waterBottomSheet.dismiss()
        }

        workout1?.setOnClickListener {
            mModel.updateExercise(10, date)
            workoutBottomSheet.dismiss()
        }
        workout2?.setOnClickListener {
            mModel.updateExercise(15, date).let {
//                workoutBottomSheet.dismiss()
            }

        }
        workout3?.setOnClickListener {
            mModel.updateExercise(30, date)
            workoutBottomSheet.dismiss()
        }
        workout4?.setOnClickListener {
            mModel.updateExercise(45, date)
            workoutBottomSheet.dismiss()
        }


        profilePhoto.setOnClickListener {
            startActivity(SettingActivity.newIntent(this))
        }

        fabMeal.setOnClickListener {
            mealBottomSheet.show()
        }

        fabWorkOut.setOnClickListener {
            workoutBottomSheet.show()
        }

        fabWater.setOnClickListener {
            waterBottomSheet.show()
        }
        mealDetailbottomsheet.behavior.peekHeight = R.dimen.margin_xxlarge
        workoutBottomSheet.behavior.peekHeight = R.dimen.margin_xxlarge
        waterBottomSheet.behavior.peekHeight = R.dimen.margin_xxlarge
        mealBottomSheet.behavior.peekHeight = R.dimen.margin_xxlarge
        mealItemBottomSheet.behavior.peekHeight = R.dimen.margin_xxlarge

        val mealItemRecyclerView = mealItemBottomSheet.findViewById<RecyclerView>(R.id.rvMealItems)
        mMealItemAdapter = MealAdapter(false, this)
        mealItemRecyclerView?.adapter = mMealItemAdapter
        mealItemRecyclerView?.layoutManager = GridLayoutManager(this, 3)

        val mealRecyclerView = mealBottomSheet.findViewById<RecyclerView>(R.id.rvMeal)
        mMealAdapter = MealAdapter(true, this)
        mealRecyclerView?.adapter = mMealAdapter
        mealRecyclerView?.layoutManager = GridLayoutManager(this, 3)

        val ingredientList: RecyclerView? = mealDetailbottomsheet.findViewById(R.id.rvIngredient)
        mealIngredientsAdapter = MealIngredientsAdapter()
        ingredientList?.adapter = mealIngredientsAdapter
        ingredientList?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        val sliderView = findViewById<SliderView>(R.id.mainCarousel)
        carouselAdapter = CarouselAdapter()
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(carouselAdapter)
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()

        val eatButton = mealDetailbottomsheet.findViewById<MaterialButton>(R.id.btnEat)
        eatButton?.setOnClickListener {
            mealDetailbottomsheet.dismiss()
        }


    }

    override fun tapOnCategory() {
        mealBottomSheet.dismiss()
        mealItemBottomSheet.show()
    }

    override fun tapOnItem() {
        mealItemBottomSheet.dismiss()
        mealDetailbottomsheet.show()
    }
}