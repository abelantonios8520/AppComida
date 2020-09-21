package com.abelsalcedo.appcomida.ui.viewmodel

import android.view.KeyEvent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.abelsalcedo.appcomida.domain.Repo
import com.abelsalcedo.appcomida.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo:Repo):ViewModel(){

    val fetchComidasList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getComidasList())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}