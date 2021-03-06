package com.erwin.subsatu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        
        val intent = Intent(this, MainActivity::class.java)
        handler.postDelayed({
            startActivity(intent)
        }, 2000L)
    }
}
