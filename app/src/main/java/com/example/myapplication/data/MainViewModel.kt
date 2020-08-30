package com.example.myapplication.data

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainViewModel : ViewModel() {

    private val _btn1 = MutableLiveData<String>().apply { postValue("Reset") }
    private val _btn2 = MutableLiveData<String>().apply { postValue("Popup") }
    private val _btn3 = MutableLiveData<String>().apply { postValue("Second Act.") }
    private val _btn4 = MutableLiveData<String>().apply { postValue("Count ++") }
    private val _count = MutableLiveData<String>().apply { postValue("0") }

    val btn1: LiveData<String> = _btn1
    val btn2: LiveData<String> = _btn2
    val btn3: LiveData<String> = _btn3
    val btn4: LiveData<String> = _btn4
    var count: LiveData<String> = _count



    //обнуление счетчика
    fun btn1Reset() {
        _count.value = "0"
    }

    //счетчик + 1
    fun countInc(){
        _count.value = (Integer.parseInt( _count.value.toString())+1).toString()
    }

}