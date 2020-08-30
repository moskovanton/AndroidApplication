package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object{
        const val TOTAL_COUNT = "total_count"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //отображение счетчика
        showCount()
        //проверка числа на полиндром
        button5.setOnClickListener{
            val number = editTextNumberDecimal.text.toString()
            textView3.text = "Palindrom"
            //вариант 1
            //for (index in 0..number.length-1) {
            //    var digit = number[index]
            //    if(number[index] !== number[number.length-1-index]) textView3.text = "Not Palindrom"
            //}
            if(number.equals(number.reversed())) textView3.text = "Palindrom"
            else textView3.text = "Not Palindrom"
        }
    }
    //считывание параметра с MainActivity
    private fun showCount () {
        textView2.text = intent.getIntExtra(TOTAL_COUNT, 0).toString()
    }

    //сохранение данных в SaveInstanceState
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("KEY", textView3.text.toString())
        }
        super.onSaveInstanceState(outState)
    }
    //передача сохраненных данных
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        textView3.text = savedInstanceState.getString("KEY")
    }
}