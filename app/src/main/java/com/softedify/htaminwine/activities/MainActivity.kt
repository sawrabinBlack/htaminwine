package com.softedify.htaminwine.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.smarteist.autoimageslider.SliderView
import com.softedify.htaminwine.R
import com.softedify.htaminwine.adapters.CarouselAdapter
import com.softedify.htaminwine.adapters.MealAdapter
import com.softedify.htaminwine.adapters.MealIngredientsAdapter
import com.softedify.htaminwine.data.models.HtaminWineModel
import com.softedify.htaminwine.data.models.HtaminWineModelImpl
import com.softedify.htaminwine.data.vos.FoodVO
import com.softedify.htaminwine.delegate.MealDelegate
import com.softedify.htaminwine.dummy.meals
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
    var foodDetailImage: ImageView? = null
    var foodProtein: TextView? = null
    var foodCalorie: TextView? = null
    var foodFat: TextView? = null
    var foodCarbs: TextView? = null
    var foodDescription: TextView? = null
    var waterCup1: RelativeLayout? = null
    var waterCup2: RelativeLayout? = null
    var waterCup3: RelativeLayout? = null
    var waterBottomSheetText :TextView? = null
    var workout1: RelativeLayout? = null
    var workout2: RelativeLayout? = null
    var workout3: RelativeLayout? = null
    var workout4: RelativeLayout? = null
    var food: FoodVO? = null
    var water: Int = 0
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
        waterBottomSheetText = waterBottomSheet.findViewById(R.id.tvTotalWater)
        workout1 = workoutBottomSheet.findViewById(R.id.rlWorkOut1)
        workout2 = workoutBottomSheet.findViewById(R.id.rlWorkOut2)
        workout3 = workoutBottomSheet.findViewById(R.id.rlWorkOut3)
        workout4 = workoutBottomSheet.findViewById(R.id.rlWorkOut4)
        foodDetailImage = mealDetailbottomsheet.findViewById(R.id.ivMeal)
        foodProtein = mealDetailbottomsheet.findViewById(R.id.tvProteinMeal)
        foodCalorie = mealDetailbottomsheet.findViewById(R.id.tvCalorieMeal)
        foodFat = mealDetailbottomsheet.findViewById(R.id.tvFatMeal)
        foodCarbs = mealDetailbottomsheet.findViewById(R.id.tvCarbsMeal)
        foodDescription = mealDetailbottomsheet.findViewById(R.id.tvMealDetail)
        calorieText = findViewById(R.id.tvTotalCalorie)
        waterText = findViewById(R.id.tvWaterAmount)
        workoutText = findViewById(R.id.tvWorkOut)
        val fabMeal: FloatingActionButton = findViewById(R.id.fabNewMeal)
        val fabWorkOut: FloatingActionButton = findViewById(R.id.fabNewWorkOut)
        val fabWater: FloatingActionButton = findViewById(R.id.fabNewWater)
        val profilePhoto: CardView = findViewById(R.id.cvProfilePhotoMain)
        mModel.createNewDailyRecord(date)
        mModel.getDailyRecordByDate(date)?.observe(this) {
            calorieText.text = "${it?.calories ?: 0} kCal"
            waterText.text = "${it?.water ?: 0} ml"
            workoutText.text = "${it?.workout} mins"
            water = it?.water ?: 0
        }
        waterCup1?.setOnClickListener {
            mModel.updateWater(100, date)
            waterBottomSheet.dismiss()
        }

        waterCup2?.setOnClickListener {
            mModel.updateWater(200, date)
            waterBottomSheet.dismiss()
        }

        waterCup3?.setOnClickListener {
            mModel.updateWater(500, date)
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
            mModel.updateExercise(60, date)
            workoutBottomSheet.dismiss()
        }

        findViewById<Button>(R.id.btnHistory).setOnClickListener {
            startActivity(History.newIntent(this))
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
            waterBottomSheetText?.text = water.toString()
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
        mMealAdapter.setCategory(meals)

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
            food?.let {
                mModel.updateFood(it, date)
            }

            mealDetailbottomsheet.dismiss()
        }


    }

    override fun tapOnCategory(foodlist: List<FoodVO>) {
        mMealItemAdapter.setFood(foodlist)
        mealBottomSheet.dismiss()
        mealItemBottomSheet.show()
    }

    override fun tapOnItem(foodVO: FoodVO) {
        food = foodVO
        mealItemBottomSheet.dismiss()
        mealDetailbottomsheet.show()
        foodDetailImage?.let { Glide.with(this).load(foodVO.foodImage).into(it) }
        foodCalorie?.text = "${foodVO.nutrient?.energy ?: 0} kCal"
        foodProtein?.text = "${foodVO.nutrient?.protein ?: 0}g"
        foodFat?.text = "${foodVO.nutrient?.fat ?: 0}g"
        foodCarbs?.text = "${foodVO.nutrient?.carbo ?: 0}g"
        foodDescription?.text = foodVO.description ?: ""
    }


}