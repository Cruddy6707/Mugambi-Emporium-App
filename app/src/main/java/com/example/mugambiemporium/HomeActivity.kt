package com.example.mugambiemporium

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    lateinit var mBtnLogout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mBtnLogout=findViewById<Button>(R.id.mBtnLogout)
        mBtnLogout.setOnClickListener {
            // Send you back to the main page
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(
                this, "Thank you, User"  +  " You have successfully Logged Out",
                Toast.LENGTH_LONG).show()
        }

    }
}