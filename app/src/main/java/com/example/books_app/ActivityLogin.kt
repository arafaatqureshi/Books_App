package com.example.books_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*

class ActivityLogin :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener {
            var ip = "http://192.168.100.149:8080/"
            var url = ip+"bookselling/login.php?phone="+
            phone_editText_login.text.toString()+"&password="+password_editText_login.text.toString()

            var rq = Volley.newRequestQueue(this)
            var str = StringRequest(Request.Method.GET, url,
                Response.Listener { response ->
                    if (response.equals("1")) {
                        startActivity(Intent(this,ActivityHome::class.java))
                    }
                    if (response.equals("0")) {

                        Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
                    }
                }
                , Response.ErrorListener { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                })
            rq.add(str)

        }

    }

}