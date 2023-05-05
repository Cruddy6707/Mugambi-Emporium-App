package com.example.mugambiemporium

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var mBtnLogin: Button
    lateinit var mBtnRegister:Button
    lateinit var mBtnWebsite: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnLogin= findViewById(R.id.mBtnLogin)
        mBtnRegister=findViewById(R.id.mBtnRegister)
        mBtnWebsite=findViewById(R.id.mBtnWebsite)

        mBtnLogin.setOnClickListener {
            val ingia = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(ingia)
        }
        mBtnRegister.setOnClickListener {
            val sajili = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(sajili)
        }


        mBtnWebsite.setOnClickListener {
            val tembea = Intent(this@MainActivity, WebsiteActivity::class.java)
            startActivity(tembea)
        }

    }
}