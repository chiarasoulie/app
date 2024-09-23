package com.example.firstapplicationchiara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstapplicationchiara.ui.theme.FirstApplicationChiaraTheme
import kotlinx.serialization.Serializable


@Serializable class DestProfil
@Serializable class DestFilms


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
            val navController = rememberNavController()
            val backstack by navController.currentBackStackEntryAsState()
            val currentDestination = backstack?.destination

            FirstApplicationChiaraTheme {
                Scaffold(
                    bottomBar = {
                        if (currentDestination?.hasRoute<DestProfil>() == false) {

                            NavigationBar {

                                NavigationBarItem(
                                    icon = {
                                        Icon(

                                            Icons.Rounded.AccountCircle,
                                            contentDescription = "menu"
                                        )
                                    }, label = { Text("Mon profil") },
                                    selected = currentDestination?.hasRoute<DestProfil>() == true,
                                    onClick = { navController.navigate(DestProfil()) })
                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            Icons.Rounded.Menu,
                                            contentDescription = "menu"
                                        )
                                    }, label = { Text("Films") },
                                    selected = currentDestination?.hasRoute<DestFilms>() == true,
                                    onClick = { navController.navigate(DestFilms()) })
                            }
                        }
                })  { innerPadding ->
                    NavHost(navController = navController, startDestination = DestProfil(), modifier = Modifier.padding(innerPadding)) {
                        composable<DestProfil> {
                            Greeting(
                                name = "app",
                                classes = windowSizeClass,
                                navController = navController
                            )
                        }
                        composable<DestFilms> { DescFilms() }

                    }
                }
            }

        }
    }
}


