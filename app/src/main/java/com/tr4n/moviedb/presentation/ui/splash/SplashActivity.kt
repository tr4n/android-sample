package com.tr4n.moviedb.presentation.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tr4n.moviedb.presentation.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
