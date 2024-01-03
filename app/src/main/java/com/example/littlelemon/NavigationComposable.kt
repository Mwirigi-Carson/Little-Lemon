package com.example.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation( navController: NavController) {

    val sharedPreferences = LocalContext.current.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)

    NavHost(navController = navController as NavHostController, startDestination = if (sharedPreferences.getBoolean("userRegistered", true)){Destinations.OnBoarding.route} else  Destinations.Home.route){
        composable(Destinations.OnBoarding.route){
            OnBoardingScreen(navController)
        }

        composable(Destinations.Home.route){
            HomeScreen(navController)
        }

        composable(Destinations.Profile.route){
            ProfileScreen(navController)
        }
    }
}