package com.baseproject.ui

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.baseproject.R
import com.baseproject.ui.dummyData.DummyActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        GlobalScope.launch {
            delay(3000)
            showLandingScreen()
        }
    }

    private fun showLandingScreen() {
        // put your logic here
        val i = Intent(this, DummyActivity::class.java)
        startActivity(i)
        finish()
    }
}