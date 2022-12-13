package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.navigation.Screen
import com.example.compose.ui.theme.ComposeTheme


class MainActivity : ComponentActivity() { //nuova activity da estendere quando usiamo compose

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //non è necessario specificare un xml
            ComposeTheme { //gestisce il tema dell'app da modificare in ui.theme.Theme
                Surface( //container degli elementi ui
                    modifier = Modifier.fillMaxSize(), //aggiungere attributi per modificare elemento ui
                    color = MaterialTheme.colors.background //specifica colore del background della surface
                ) {
                    //inserire elementi della ui
                    //Layout Box,Column,Row
                    //{Recompose}->{Structure}->{Presentation}
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    val items = listOf(
        Screen.First,
        Screen.Second,
    )

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        MainNavHost(
            navController,
            modifier = Modifier.padding(innerPadding)
        ) //funzione composable che gestisce la navigazione tra composable
    }

}
