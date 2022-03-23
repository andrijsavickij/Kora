package com.andrj.kora

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


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
        Toast.makeText(applicationContext, "choose", Toast.LENGTH_LONG).show()

        val constraintLayout = ConstraintLayout(this)
        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.login)

        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        imageView.setLayoutParams(layoutParams)
        constraintLayout.addView(imageView)

        setContentView(constraintLayout)


    }
    fun phone(){
        Toast.makeText(applicationContext, "phone", Toast.LENGTH_LONG).show()
    }
    fun book(){
        Toast.makeText(applicationContext, "book", Toast.LENGTH_LONG).show()
    }
    fun google(){
        Toast.makeText(applicationContext, "google", Toast.LENGTH_LONG).show()
    }
    fun data(){
        Toast.makeText(applicationContext, "data", Toast.LENGTH_LONG).show()
    }

    enum class Status {CHOOSE, PHONE, BOOK, GOOGLE, DADA}
}



