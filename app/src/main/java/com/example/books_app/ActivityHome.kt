package com.example.books_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.home.*

class ActivityHome :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)


        button_sell_home.setOnClickListener {

            startActivity(Intent(this,ActiviySell::class.java))

        }


    }

}