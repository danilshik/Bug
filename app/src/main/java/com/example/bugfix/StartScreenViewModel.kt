package com.example.bugfix


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.peshkariki.newPesh.newTwoAuth.startScreen.StartScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartScreenViewModel: ViewModel(){

    private val _state = MutableLiveData<StartScreenState>()
    val state : LiveData<StartScreenState>
        get() = _state

    fun start() {
        _state.value = StartScreenState.START_ANIMATION
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
        }
    }
}