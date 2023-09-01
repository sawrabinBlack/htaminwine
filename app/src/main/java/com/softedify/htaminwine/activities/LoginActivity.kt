package com.softedify.htaminwine.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.softedify.htaminwine.R
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,LoginActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton : MaterialButton = findViewById(R.id.btnLogin)
        val signUp : TextView = findViewById(R.id.tvSignUpLogIn)
        loginButton.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
        }

        signUp.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }

    }
}