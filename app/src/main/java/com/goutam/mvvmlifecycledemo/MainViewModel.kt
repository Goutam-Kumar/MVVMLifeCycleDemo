package com.goutam.mvvmlifecycledemo

import android.util.Log
import androidx.lifecycle.*

class MainViewModel( private val testInt: Int = 0): ViewModel(), LifecycleObserver {

    private val _onDestroyObserved = MutableLiveData<Boolean>(false)
    val onDestroyObserved: LiveData<Boolean> = _onDestroyObserved

    init {
        Log.d("Goutam", "Integer initialized to : $testInt")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeInvoked(){
        Log.d("Goutam", "OnResume Invoked")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyInvoked(){
        Log.d("Goutam", "OnDestroy Invoked")
        _onDestroyObserved.value = true
    }
}
