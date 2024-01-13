package com.example.studentdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
//import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : ComponentActivity() {
    private lateinit var iv_user : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        iv_user=findViewById(R.id.iv_user)
        iv_user.alpha = 0f
        iv_user.animate().setDuration(1500).alpha(1f).withEndAction {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}