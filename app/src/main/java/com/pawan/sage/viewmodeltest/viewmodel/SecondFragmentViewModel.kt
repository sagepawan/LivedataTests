package com.pawan.sage.viewmodeltest.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondFragmentViewModel: ViewModel() {

    private lateinit var timer: CountDownTimer

    private var _seconds = MutableLiveData<Int>()

    fun startTimer(){
        timer = object : CountDownTimer(10000, 1000){
            override fun onTick(millis: Long) {
                var timeLeft = millis/1000      //convert to seconds
                _seconds.value = timeLeft.toInt()   //update livedata
            }

            override fun onFinish() {

            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}