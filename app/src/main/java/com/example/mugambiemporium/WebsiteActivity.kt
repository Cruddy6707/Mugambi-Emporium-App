package com.example.mugambiemporium

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView

import androidx.appcompat.app.AppCompatActivity

class WebsiteActivity : AppCompatActivity() {
    lateinit var myWeb : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)
        myWeb = findViewById(R.id.mWeb)
        val webSettings = myWeb.settings
        webSettings.javaScriptEnabled = true
        myWeb.loadUrl("https://www.youtube.com/watch?v=z5T_XOm4lPg")
    }
}