package com.example.littlelemon

sealed class Destinations (var route : String){
    object OnBoarding : Destinations("onboarding")
    object  Home : Destinations("home")
    object  Profile : Destinations("profile")
}