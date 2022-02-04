package com.pawan.sage.viewmodeltest.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondFragmentViewModel: ViewModel() {

    private lateinit var timer: CountDownTimer

    //private to view model
    private var _seconds = MutableLiveData<Int>()

    private var _finished = MutableLiveData<Boolean>()

    //for public access from observer class
    val seconds: LiveData<Int> get() = _seconds

    val finished: LiveData<Boolean> get() = _finished

    fun startTimer(){
        timer = object : CountDownTimer(10000, 1000){
            override fun onTick(millis: Long) {
                var timeLeft = millis/1000      //convert to seconds
                _seconds.value = timeLeft.toInt()   //update livedata
                _finished.value = false
            }

            override fun onFinish() {
                _finished.value = true
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}