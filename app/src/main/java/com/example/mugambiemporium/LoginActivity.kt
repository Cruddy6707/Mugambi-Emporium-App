package com.example.mugambiemporium

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {


    lateinit var mEdtPassword: EditText
    lateinit var mEdtEmail: EditText
    lateinit var mCheckRememberMe: CheckBox
    lateinit var mBtnLogin: Button
    lateinit var mTxtAdminPanelLink: TextView
    lateinit var mTxtNotAdminPanelLink: TextView
    lateinit var progressDialog: ProgressDialog
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mEdtPassword = findViewById(R.id.mEdtPassword)
        mEdtEmail = findViewById(R.id.mEdtEmail)
        mCheckRememberMe = findViewById(R.id.mCheckRememberMe)
        mBtnLogin = findViewById(R.id.mBtnLogin)
        mTxtAdminPanelLink = findViewById(R.id.mTxtAdminPanelLink)
        mTxtNotAdminPanelLink = findViewById(R.id.mTxtNotAdminPanelLink)
        mAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Logging In")
        progressDialog.setMessage("Please Wait.........")
        mBtnLogin.setOnClickListener {
            val email = mEdtEmail.text.toString()
            val password = mEdtPassword.text.toString()

            if (password.isEmpty()) {
                mEdtPassword.setError("Please fill in this field")
                mEdtPassword.requestFocus()
            } else {

                // Showing Progress of saving
                progressDialog.show()
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    progressDialog.dismiss()
                    if (it.isSuccessful) {
                        Toast.makeText(
                            this, "Welcome, User" + " You have successfully Logged in",
                            Toast.LENGTH_LONG
                        ).show()
                        //Firebase registered User
                        val intent = Intent(this@LoginActivity,HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Awwwww, User Something happened" + "You not been able to successfully Register",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}

