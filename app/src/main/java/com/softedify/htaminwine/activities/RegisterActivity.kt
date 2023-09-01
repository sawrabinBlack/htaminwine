package com.softedify.htaminwine.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.softedify.htaminwine.R

class RegisterActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,RegisterActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton : MaterialButton = findViewById(R.id.btnRegister)
        registerButton.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
        }

    }
}