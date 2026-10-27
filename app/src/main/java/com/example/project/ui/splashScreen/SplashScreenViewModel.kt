package com.example.project.ui.splashScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.project.data.repository.AuthorizationRepository
class SplashScreenViewModel(val repository: AuthorizationRepository): ViewModel() {

    fun checkToken(context: Context): Boolean{
        return repository.getToken(context) != null
    }
}