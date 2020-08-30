package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.data.MainViewModel
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    lateinit var myObserver: MyObserver         //поздняя инициализация

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewmodel = viewModel

        binding.lifecycleOwner = this

        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)       //пишем lifecycle  в log

    }
    //всплывающее сообщение при нажатии кнопки, когда switch ON + счетчик+1
    fun popup(view: View){
        Toast.makeText(this, "popup", Toast.LENGTH_SHORT).show()
    }
    //передача параметра в SecondActivity
    fun secondAct(view: View) {
        val secondInt = Intent(this, SecondActivity::class.java)
        secondInt.putExtra(SecondActivity.TOTAL_COUNT, Integer.parseInt(textView.text.toString()))
        startActivity(secondInt)
    }

    /* c viewmodel не нужно
    //сохранение данных в SaveInstanceState
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("KEY", textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }
    //передача сохраненных данных
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        textView.text = savedInstanceState.getString("KEY")
    }
    */

}