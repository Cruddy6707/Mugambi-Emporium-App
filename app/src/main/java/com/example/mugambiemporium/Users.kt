package com.example.mugambiemporium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class User {
    var name:String = ""
    var phone:String = ""
    var password:String = ""

    constructor(name:String,phone:String,password: String){
        this.name = name
        this.phone = phone
        this.password = password


    }
    constructor()
}