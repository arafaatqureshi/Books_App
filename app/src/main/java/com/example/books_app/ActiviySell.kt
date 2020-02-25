package com.example.books_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.sell_book.*

class ActiviySell :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sell_book)

       sell_book_button.setOnClickListener {

           var ip = "http://192.168.100.149:8080/"
           var url =
               ip+"bookselling/sellbook.php?book="+
                       book_title_editText.text.toString()+"&author="+book_author_editText.text.toString()+
                       "&mrp="+book_price_editText.text.toString()
           "&category="+book_category_editText.text.toString()+"&board="+edu_Board_editText.text.toString()
           var rq = Volley.newRequestQueue(this)
           var str = StringRequest(Request.Method.GET, url,
               Response.Listener { response ->
                   if (response.equals("1")) {
                       Toast.makeText(this, "Book Data Added", Toast.LENGTH_SHORT).show()
                       startActivity(Intent(this,ActivityHome::class.java))
                   }
                   else {

                       Toast.makeText(this, "Failed to Add book data", Toast.LENGTH_SHORT).show()


                   }
               }
               , Response.ErrorListener { error ->
                   Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
               })
           rq.add(str)

       }
    }

}