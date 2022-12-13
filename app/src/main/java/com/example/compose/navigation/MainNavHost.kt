package com.example.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.data.ListRepositoryMock
import com.example.compose.navigation.Screen
import com.example.compose.ui.main.FirstScreen
import com.example.compose.ui.second.SecondScreen

@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.First.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        //per ogni schermata dichiarare un composable con route
        composable(Screen.First.route) {
            FirstScreen(
                viewModel = viewModel(),
                onClickToNavigate = { name ->
                    //navcontroller mi permette di cambiare schermata
                    navController.navigate(Screen.Second.route)
                }
            )
        }
        composable(
            route = Screen.Second.route
        ) {
            SecondScreen(viewModel())
        }
    }
}