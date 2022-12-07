package com.example.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination : String = "main"
){
    NavHost(navController = navController, startDestination = startDestination){
        composable("main"){
            MainScreen(viewModel()){ name ->
                navController.navigate("second/$name")
            }
        }
        composable(
            route ="second/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ){
            it.arguments?.getString("name")?.let { name -> SecondScreen(name) }
        }
    }
}