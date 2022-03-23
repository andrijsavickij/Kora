package com.andrj.kora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private var status: Status? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        status = Status.CHOOSE
    }

    override fun onResume(){
        super.onResume()
        when (status){
            Status.CHOOSE -> choose()
            Status.PHONE -> phone()
            Status.BOOK -> book()
            Status.GOOGLE -> google()
            Status.DADA -> data()
            else -> {status = Status.CHOOSE; choose();}
        }
    }

    fun choose(){
        Toast.makeText(applicationContext, "choose", Toast.LENGTH_SHORT).show()
    }
    fun phone(){
        Toast.makeText(applicationContext, "phone", Toast.LENGTH_SHORT).show()
    }
    fun book(){
        Toast.makeText(applicationContext, "book", Toast.LENGTH_SHORT).show()
    }
    fun google(){
        Toast.makeText(applicationContext, "google", Toast.LENGTH_SHORT).show()
    }
    fun data(){
        Toast.makeText(applicationContext, "data", Toast.LENGTH_SHORT).show()
    }

    enum class Status {CHOOSE, PHONE, BOOK, GOOGLE, DADA}
}



