package com.andrj.kora

import android.os.Bundle
import android.text.InputType
import android.util.DisplayMetrics
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible


class LoginActivity : AppCompatActivity() {

    private var status: Status? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        status = Status.CHOOSE
    }

    override fun onResume(){
        super.onResume()
        setViews()
    }

    private fun setViews(){
        val list: LinearLayout = findViewById(R.id.logVL)
        list.removeAllViews();
        when (status){
            Status.CHOOSE -> {
                //Toast.makeText(applicationContext, "choose", Toast.LENGTH_SHORT).show()
                val imageView = ImageView(this)
                imageView.setImageResource(R.drawable.login)

                val text = TextView(this);
                text.text = "Вхід"
                text.textSize = 20f;
                text.gravity = Gravity.CENTER

                val buttPhone = Button(this)
                val buttBook = Button(this)
                val buttGoogle = Button(this)
                buttBook.text = "Facebook"
                buttPhone.text = "Phone"
                buttGoogle.text = "Google"
                val linear = LinearLayout(this)
                linear.gravity = Gravity.CENTER
                linear.addView(buttBook)
                linear.addView(buttGoogle)
                linear.addView(buttPhone)

                imageView.setPadding(0,0,0,todp(50))
                text.setPadding(0,0,0,todp(50))
                linear.setPadding(0,0,0,todp(50))
                list.addView(imageView)
                list.addView(text)
                list.addView(linear)

                buttBook.setOnClickListener{
                    status = Status.BOOK
                    setViews()
                }
                buttPhone.setOnClickListener{
                    status = Status.PHONE
                    setViews()
                }
                buttGoogle.setOnClickListener{
                    status = Status.GOOGLE
                    setViews()
                }

            }
            Status.PHONE -> {
                //Toast.makeText(applicationContext, "phone", Toast.LENGTH_SHORT).show()
                val imageView = ImageView(this)
                imageView.setImageResource(R.drawable.login)

                val text = TextView(this);
                text.text = "Вхід"
                text.textSize = 30f;
                text.gravity = Gravity.CENTER

                val edit = EditText(this)
                edit.inputType = InputType.TYPE_CLASS_PHONE
                edit.width = todp(150)
                edit.gravity = Gravity.CENTER
                edit.height = todp(15)

                val butt = Button(this)
                butt.width = todp(150)
                //butt.gravity = Gravity.CENTER
                butt.text = "Верефікувати"
                butt.textSize = 15f
                butt.height = todp(15)

                imageView.setPadding(0,0,0,todp(10))
                text.setPadding(0,0,0,todp(30))
                edit.setPadding(0,0,0,todp(30))
                butt.setPadding(0,0,0,todp(10))
                list.addView(imageView)
                list.addView(text)
                list.addView(edit)
                list.addView(butt)

                butt.setOnClickListener{
                    //some magic with verification phone
                    //to|do save user info
                    edit.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                    butt.text = "Далі"
                    butt.setOnClickListener{
                        //to|do save user info
                        status = Status.DADA
                        setViews()
                    }
                }


            }
            Status.DADA -> {
                //Toast.makeText(applicationContext, "data", Toast.LENGTH_SHORT).show()

                val nameW = TextView(this)
                val surnameW = TextView(this)
                val cityW = TextView(this)
                nameW.width         = todp(150)
                surnameW.width      = todp(150)
                cityW.width         = todp(150)
                nameW.gravity       = Gravity.LEFT
                surnameW.gravity    = Gravity.LEFT
                cityW.gravity       = Gravity.LEFT
                nameW.height        = todp(9)
                surnameW.height     = todp(9)
                cityW.height        = todp(9)
                nameW.text          = "Поле не повинно бути порожнім або містити цифри"
                surnameW.text       = "Поле не повинно бути порожнім або містити цифри"
                cityW.text          = "Поле не повинно бути порожнім"
                nameW.isVisible     = false
                surnameW.isVisible  = false
                cityW.isVisible     = false

                val name = EditText(this)
                name.inputType = InputType.TYPE_CLASS_TEXT
                name.width = todp(150)
                name.gravity = Gravity.CENTER
                name.height = todp(15)
                name.hint = "Ім'я"
                val surname = EditText(this)
                surname.inputType = InputType.TYPE_CLASS_TEXT
                surname.width = todp(150)
                surname.gravity = Gravity.CENTER
                surname.height = todp(15)
                surname.hint = "Прізвище"
                val city = EditText(this)
                city.inputType = InputType.TYPE_CLASS_TEXT
                city.width = todp(150)
                city.gravity = Gravity.CENTER
                city.height = todp(15)
                city.hint = "Місто"

                val butt = Button(this)
                butt.width = todp(150)
                //butt.gravity = Gravity.CENTER
                butt.textSize = 15f
                butt.height = todp(15)
                butt.text = "Далі"
                butt.setOnClickListener{
                    //to|do save user info

                }

                name.setPadding(0,0,0,todp(1))
                nameW.setPadding(0,0,0,todp(30))
                surname.setPadding(0,0,0,todp(1))
                surnameW.setPadding(0,0,0,todp(30))
                city.setPadding(0,0,0,todp(1))
                cityW.setPadding(0,0,0,todp(30))
                butt.setPadding(0,todp(40),0,todp(10))

                list.addView(name)
                list.addView(nameW)
                list.addView(surname)
                list.addView(surnameW)
                list.addView(city)
                list.addView(cityW)
                list.addView(butt)

            }
            Status.BOOK -> {
                Toast.makeText(applicationContext, "doesn't work", Toast.LENGTH_SHORT).show()
                //todo do it
                status = Status.CHOOSE
                setViews()
            }
            Status.GOOGLE -> {
                Toast.makeText(applicationContext, "doesn't work", Toast.LENGTH_SHORT).show()
                //todo do it
                status = Status.CHOOSE
                setViews()
            }
            else -> {status = Status.CHOOSE; setViews();}
        }
    }


    private fun todp(px: Int): Int {
        return (px * resources.displayMetrics.density + 0.5f).toInt()
    }
    enum class Status {CHOOSE, PHONE, BOOK, GOOGLE, DADA}
}



