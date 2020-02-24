package com.example.books_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_text.setOnClickListener {
        startActivity(Intent(this,ActivityLogin::class.java))

        }

        register_button.setOnClickListener {

            var ip = "http://192.168.100.149:8080/"
            var url =
                ip +"bookselling/addusersignup.php?name="+
                        name_editText.text.toString()+"&phone="+phone_editText.text.toString()+
                        "&password="+password_editText.text.toString()
                        "&city="+city_editText.text.toString()
            var rq = Volley.newRequestQueue(this)
            var str = StringRequest(Request.Method.GET, url,
                Response.Listener { response ->
                    if (response.equals("0")) {
                        Toast.makeText(this, "Sorry! Duplicate phone number", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,ActivityHome::class.java))


                    }
                }
                , Response.ErrorListener { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                })
            rq.add(str)

        }

    }
}
