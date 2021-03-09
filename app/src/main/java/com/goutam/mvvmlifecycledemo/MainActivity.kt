package com.goutam.mvvmlifecycledemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.goutam.mvvmlifecycledemo.viewmodelhelpers.MVVMUtils

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this, MVVMUtils.getViewModelFactory { MainViewModel(10) }).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addLifeCycleObserver()
        viewModelObserver()
    }

    private fun viewModelObserver() {
        viewModel.onDestroyObserved.observe(this, Observer {
            if (it){
                Log.d("Goutam", "LifeCycle Observer removed")
                lifecycle.removeObserver(viewModel)
            }
        })
    }

    private fun addLifeCycleObserver() {
        lifecycle.addObserver(viewModel)
        Log.d("Goutam", "LifeCycle Observer added")
    }
}
