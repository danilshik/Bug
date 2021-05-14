package com.app.peshkariki.newPesh.newTwoAuth.startScreen

sealed class StartScreenState(){
    object LOADING : StartScreenState()
    object START_ANIMATION: StartScreenState()
    object CLOSE_ANIMATION: StartScreenState()
    object LOAD_CONFIRM: StartScreenState()
    object LOAD_MAIN: StartScreenState()
    data class LOAD_CREATE_ORDER(val url: String) : StartScreenState()
}