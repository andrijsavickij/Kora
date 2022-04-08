package com.andrj.kora

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
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
        val WIDTH = dp(300)
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

                imageView.setPadding(0,0,0,dp(50))
                text.setPadding(0,0,0,dp(50))
                linear.setPadding(0,0,0,dp(50))
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
                edit.width = WIDTH
                edit.gravity = Gravity.CENTER
                edit.height = dp(15)

                val butt = Button(this)
                butt.width = WIDTH
                //butt.gravity = Gravity.CENTER
                butt.text = "Верефікувати"
                butt.textSize = 15f
                butt.height = dp(15)

                imageView.setPadding(0,0,0,dp(10))
                text.setPadding(0,0,0,dp(30))
                edit.setPadding(0,0,0,dp(30))
                butt.setPadding(0,0,0,dp(10))
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

                val name        = EditText(this)
                val nameW       = TextView(this)
                val surname     = EditText(this)
                val surnameW    = TextView(this)
                val city        = EditText(this)
                val cityW       = TextView(this)

                nameW.width         = WIDTH
                surnameW.width      = WIDTH
                cityW.width         = WIDTH
                nameW.gravity       = Gravity.LEFT
                surnameW.gravity    = Gravity.LEFT
                cityW.gravity       = Gravity.LEFT
                nameW.textSize      = 12f
                surnameW.textSize   = 12f
                cityW.textSize      = 12f
                nameW.text          = "Поле не повинно бути порожнім або містити цифри"
                surnameW.text       = "Поле не повинно бути порожнім або містити цифри"
                cityW.text          = "Поле не повинно бути порожнім"
                nameW.visibility    = View.INVISIBLE
                surnameW.visibility = View.INVISIBLE
                cityW.visibility    = View.INVISIBLE

                //name.inputType      = InputType.TYPE_CLASS_TEXT
                //surname.inputType   = InputType.TYPE_CLASS_TEXT
                //city.inputType      = InputType.TYPE_CLASS_TEXT
                name.width          = WIDTH
                surname.width       = WIDTH
                city.width          = WIDTH
                name.gravity        = Gravity.LEFT
                surname.gravity     = Gravity.LEFT
                city.gravity        = Gravity.LEFT
                name.height         = dp(15)
                surname.height      = dp(15)
                city.height         = dp(15)
                name.hint           = "Ім'я"
                surname.hint        = "Прізвище"
                city.hint           = "Місто"


                val butt = Button(this)
                //butt.width = todp(150)
                //butt.gravity = Gravity.CENTER
                butt.textSize = 15f
                butt.height = dp(15)
                butt.text = "Далі"
                butt.setOnClickListener{
                    //to|do save user info

                    nameW.visibility    = View.VISIBLE
                    surnameW.visibility = View.VISIBLE
                    cityW.visibility    = View.VISIBLE
                }

                name.setPadding     (0,0,0,dp(1))
                nameW.setPadding    (0,0,0,dp(15))
                surname.setPadding  (0,0,0,dp(1))
                surnameW.setPadding (0,0,0,dp(15))
                city.setPadding     (0,0,0,dp(1))
                cityW.setPadding    (0,0,0,dp(15))
                butt.setPadding     (0,dp(40),0,dp(10))

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


    private fun dp(px: Int): Int {
        return (px * resources.displayMetrics.density + 0.5f).toInt()
    }
    enum class Status {CHOOSE, PHONE, BOOK, GOOGLE, DADA}
}

class EditTextView(context: Context, WIDTH_dp: Int, inputType: Int, hint: String,errorMessage: String) : LinearLayout(context){
    val edit    = EditText(context)
    val error   = TextView(context)

    val WIDTH = WIDTH_dp
    init{
        this.setLayoutParams( LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        this.addView(edit)
        this.addView(error)
        edit.width  = WIDTH
        error.width = WIDTH
        error.gravity = Gravity.LEFT
        edit.gravity = Gravity.LEFT
        edit.inputType = inputType
        edit.hint = hint
        error.setPadding(0,dp(1),0,0)
        error.text = errorMessage
    }

    fun setWidthToAll(width_dp: Int){
        edit.width  = width_dp
        error.width = width_dp
    }

    fun switchError(){
        if(error.isVisible) error.visibility = View.INVISIBLE
        else error.visibility = View.VISIBLE
    }


    private fun dp(px: Int): Int {
        return (px * resources.displayMetrics.density + 0.5f).toInt()
    }
}



