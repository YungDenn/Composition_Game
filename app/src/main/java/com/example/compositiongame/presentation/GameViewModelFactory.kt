package com.example.compositiongame.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.compositiongame.domain.entity.Level
import java.lang.RuntimeException

class GameViewModelFactory(
    private val level: Level,
    private val application: Application
    ): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //Проверка на получение GameViewModel, при попытки получить дргую ViewModel -> exception
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(application, level) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")
    }
}