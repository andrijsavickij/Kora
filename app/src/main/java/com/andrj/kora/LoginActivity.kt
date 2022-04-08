package com.andrj.kora

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Message
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2


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
        list.removeAllViews()
        val WIDTH = dp(300)
        when (status){
            Status.CHOOSE -> {
                //Toast.makeText(applicationContext, "choose", Toast.LENGTH_SHORT).show()
                val imageView = ImageView(this)
                imageView.setImageResource(R.drawable.login)

                val text = TextView(this)
                text.text = "Вхід"
                text.textSize = 20f
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

                val text = TextView(this)
                text.text = "Вхід"
                text.textSize = 30f
                text.gravity = Gravity.CENTER

                val edit = EditTextView(this,WIDTH,InputType.TYPE_CLASS_PHONE,"","номер не дійсний")

                val butt = Button(this)
                butt.width = WIDTH
                //butt.gravity = Gravity.CENTER
                butt.text = "Верефікувати"
                butt.textSize = 15f
                butt.height = dp(15)

                imageView.setPadding(0,0,0,dp(10))
                text.setPadding(0,0,0,dp(30))
                edit.setPadding(0,0,0,dp(5))
                butt.setPadding(0,0,0,dp(10))
                list.addView(imageView)
                list.addView(text)
                list.addView(edit)
                list.addView(butt)

                butt.setOnClickListener{
                    //some magic with verification phone
                    //to|do save user info
                    edit.switchError()
                    edit.edit.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                    edit.error.text = "пароль не має містити цифри та пробіли"
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

                val name    = EditTextView(this,WIDTH,InputType.TYPE_CLASS_TEXT,"Ім'я","Поле не повинно бути порожнім або містити цифри")
                val surname = EditTextView(this,WIDTH,InputType.TYPE_CLASS_TEXT,"Прізвище","Поле не повинно бути порожнім або містити цифри")
                val city    = EditTextView(this,WIDTH,InputType.TYPE_CLASS_TEXT,"Місто","Поле не повинно бути порожнім")

                val butt = Button(this)

                butt.textSize = 15f
                butt.height = dp(15)
                butt.text = "Далі"
                butt.setOnClickListener{
                    //to|do save user info
                    name.switchError()
                    //surname.switchError()
                    city.switchError()
                }

                list.addView(name)
                list.addView(surname)
                list.addView(city)
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
        this.setOrientation(VERTICAL)
        this.setLayoutParams( LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        this.addView(edit)
        this.addView(error)
        edit.width  = WIDTH
        error.width = WIDTH
        error.gravity = Gravity.START
        edit.gravity = Gravity.START
        edit.inputType = inputType
        edit.hint = hint
        error.text = errorMessage
        error.visibility = View.INVISIBLE

        error.textSize = 1f
        error.setTextColor(ContextCompat.getColor(context, R.color.error))
        edit.setHintTextColor(ContextCompat.getColor(context, R.color.text))
    }

//    fun setWidthToAll(width_dp: Int){
//        edit.width  = width_dp
//        error.width = width_dp
//    }

    fun switchError(){
        error.textSize = 14f
        if(error.isVisible) error.visibility = View.INVISIBLE
        else error.visibility = View.VISIBLE
    }

}



