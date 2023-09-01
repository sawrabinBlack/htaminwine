package com.softedify.htaminwine.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.softedify.htaminwine.R

class EditProfileActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,EditProfileActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val updateButton : MaterialButton = findViewById(R.id.btnUpdateProfile)
        updateButton.setOnClickListener {
            startActivity(SettingActivity.newIntent(this))
        }
    }
}