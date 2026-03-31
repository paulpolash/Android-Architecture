package com.example.androidarchitecture.ui.navigation

sealed class Routes(var route: String) {
    object Home : Routes("home")
    object PersonDetails : Routes("detail/{personId}"){
        fun createRoute(personId: Int) = "detail/$personId"
    }
    object Settings : Routes("settings")
    object Login : Routes("login")
    object Register : Routes("register")

}