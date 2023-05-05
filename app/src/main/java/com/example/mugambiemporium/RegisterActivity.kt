package com.example.mugambiemporium

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    lateinit var mBtnCreateAccount:Button
    lateinit var mEdtRegName: EditText
    lateinit var mEdtRegEmail:EditText
    lateinit var mEdtRegPhoneNumber: EditText
    lateinit var mEdtRegPassword: EditText
    lateinit var progressDialog:ProgressDialog
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mBtnCreateAccount=findViewById(R.id.mBtnCreateAccount)
        mEdtRegName=findViewById(R.id.mEdtRegName)
        mEdtRegEmail=findViewById(R.id.mEdtRegEmail)
        mEdtRegPhoneNumber = findViewById(R.id.mEdtRegPhoneNumber)
        mEdtRegPassword = findViewById(R.id.mEdtRegPassword)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Registering")
        progressDialog.setMessage("Please Wait.........")
        mAuth = FirebaseAuth.getInstance()
        mBtnCreateAccount.setOnClickListener {
            var name = mEdtRegName.text.toString().trim()
             var email = mEdtRegEmail.text.toString().trim()
            var phone = mEdtRegPhoneNumber.text.toString().trim()
            var password = mEdtRegPassword.text.toString().trim()
            val id = System.currentTimeMillis().toString()
            // Store data in shared preference file
            /*val sharedPreferences = getSharedPreferences("TheRegs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("name", name)
            editor.putString("email", email)
            editor.putString("phone", phone)
            editor.putString("password", password)
            editor.apply()*/



            if (name.isEmpty()) {
                mEdtRegName.setError("Please fill in this field")
                mEdtRegName.requestFocus()
            } else if (phone.isEmpty()) {
                mEdtRegPhoneNumber.setError("Please fill in this field")
                mEdtRegPhoneNumber.requestFocus()
            } else if (password.isEmpty()) {
                mEdtRegPassword.setError("Please fill in this field")
                mEdtRegPassword.requestFocus()
            } else {
                progressDialog.show()
                mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    //Dismiss the progress and check if the task was successful
                        task ->
                    progressDialog.dismiss()
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "Welcome, $name"  +  " You have successfully Registered",
                            Toast.LENGTH_LONG
                        ).show()
                        // Open login activity
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(
                            this,
                            "Awwwww, $name Something happened" + "You not been able to successfully Register",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }
            }
        }

    }
}