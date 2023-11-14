package com.udeldev.contactapp.presentation.util

sealed class Screen (val route : String) {
    data object HomeScreen : Screen("home")
}