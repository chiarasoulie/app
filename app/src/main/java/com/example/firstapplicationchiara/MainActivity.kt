package com.example.firstapplicationchiara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewmodel : MainViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
            val navController = rememberNavController()
            val backstack by navController.currentBackStackEntryAsState()
            val currentDestination = backstack?.destination

            FirstApplicationChiaraTheme {
                Scaffold(
                    topBar = {
                        SearchBar(
                            query = searchQuery.text,
                            onQueryChange = { newValue -> searchQuery = TextFieldValue(newValue) },
                            onSearch = { isSearchActive = false },
                            active = isSearchActive,
                            onActiveChange = { isActive -> isSearchActive = isActive },
                            placeholder = { Text("Rechercher un film") },
                            leadingIcon = {
                                Icon(imageVector = Icons.Rounded.Search, contentDescription = "Icône de recherche")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            // Suggestions ou résultats de recherche peuvent être ajoutés ici si nécessaire
                        }
                    },
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
                        composable<DestFilms> { DescFilms(viewmodel) }

                    }
                }
            }

        }
    }
}


