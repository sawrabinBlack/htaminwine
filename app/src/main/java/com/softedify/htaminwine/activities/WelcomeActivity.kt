package com.softedify.htaminwine.activities



import android.content.ClipData.newIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.softedify.htaminwine.R
import kotlin.math.log

class WelcomeActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,WelcomeActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val welcomeButton : MaterialButton = findViewById(R.id.btnWelcome)
        val logInButton : TextView = findViewById(R.id.tvWelcomeLogin)
        welcomeButton.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }
        logInButton.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
        }
    }
}