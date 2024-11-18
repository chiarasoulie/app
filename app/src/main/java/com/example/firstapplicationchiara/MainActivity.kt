package com.example.firstapplicationchiara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstapplicationchiara.ui.theme.FirstApplicationChiaraTheme
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.Serializable


@Serializable class DestProfil
@Serializable class DestFilms
@Serializable class DestSeries
@Serializable class DestActeurs


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

            var searchText by remember { mutableStateOf("") }
            var isSearching by remember { mutableStateOf(false) }


            FirstApplicationChiaraTheme {
                Scaffold(
                        topBar = {
                            if (currentDestination?.hasRoute<DestProfil>() == false) {
                            SearchBar(
                                query = searchText,
                                onQueryChange = {
                                    searchText = it
                                                },
                                onSearch = {
                                    if (currentDestination?.hasRoute<DestFilms>() == true){
                                        viewmodel.searchMovies(it)
                                    }
                                    if (currentDestination?.hasRoute<DestSeries>() == true){
                                        viewmodel.searchSeries(it)
                                    }
                                    if (currentDestination?.hasRoute<DestActeurs>() == true){
                                        viewmodel.searchActeurs(it)
                                    }
                                    isSearching = false
                                },
                                active = isSearching,
                                onActiveChange = { isSearching = it },
                                placeholder = { Text("Rechercher...") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Rounded.Search,
                                        contentDescription = "Icône de recherche"
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)

                            ) {
                            }
                        }
                    },
                    bottomBar = {
                        if (currentDestination?.hasRoute<DestProfil>() == false) {

                            NavigationBar {

                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            Icons.Rounded.Star,
                                            contentDescription = "menu"
                                        )
                                    }, label = { Text("Films") },
                                    selected = currentDestination?.hasRoute<DestFilms>() == true,
                                    onClick = { navController.navigate(DestFilms())
                                                searchText = ""})
                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            Icons.Rounded.Notifications,
                                            contentDescription = "menu"
                                        )
                                    }, label = { Text("Series") },
                                    selected = currentDestination?.hasRoute<DestSeries>() == true,
                                    onClick = { navController.navigate(DestSeries())
                                                searchText = ""})
                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            Icons.Rounded.Face,
                                            contentDescription = "menu"
                                        )
                                    }, label = { Text("Acteurs") },
                                    selected = currentDestination?.hasRoute<DestActeurs>() == true,
                                    onClick = { navController.navigate(DestActeurs())
                                        searchText = ""})
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
                        composable<DestSeries> { DescSeries(viewmodel) }
                        composable<DestActeurs> { DescActeurs(viewmodel) }

                    }
                }
            }

        }
    }
}


