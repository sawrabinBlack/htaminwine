package com.softedify.htaminwine.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.softedify.htaminwine.R
import kotlin.math.log

class SettingActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,SettingActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting2)
        val editProfile : LinearLayout = findViewById(R.id.llEditProfile)
        val logOut : LinearLayout = findViewById(R.id.llLogOut)
        editProfile.setOnClickListener{
            startActivity(EditProfileActivity.newIntent(this))
        }
        logOut.setOnClickListener{
            startActivity(LoginActivity.newIntent(this))
        }
    }
}