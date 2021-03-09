package com.goutam.mvvmlifecycledemo.viewmodelhelpers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
internal class MVVMUtils {
    companion object{
        
        inline fun <V: ViewModel> getViewModelFactory(crossinline getViewModelObject: () -> V): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return getViewModelObject() as T
                }
            }
        }

    }
}
