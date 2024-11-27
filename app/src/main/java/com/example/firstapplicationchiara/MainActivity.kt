package com.example.firstapplicationchiara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.firstapplicationchiara.ui.theme.FirstApplicationChiaraTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable



@Serializable class DestProfil
@Serializable class DestFilms
@Serializable class DestSeries
@Serializable class DestActeurs
@Serializable data class Film(val id: String)
@Serializable data class Serie(val id: String)



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewmodel : MainViewModel by viewModels()


        enableEdgeToEdge()
        setContent {
            FirstApplicationChiaraTheme {
                MainScreen(viewmodel)
            }

        }
    }
    /**
    * Fonction principale de l'écran :configure l'interface utilisateur en fonction de la largeur de l'écran (portrait ou paysage)
    * et gère la navigation entre les différentes sections de l'application (Films, Séries, Acteurs).
    * Paramètres :
    * @param viewmodel - Le ViewModel principal pour gérer les données des composables.
    */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
     fun MainScreen(
        viewmodel: MainViewModel,
    ) {

        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val navController = rememberNavController()
        val backstack by navController.currentBackStackEntryAsState()
        val currentDestination = backstack?.destination

        var searchText by remember { mutableStateOf("") }
        var isSearching by remember { mutableStateOf(false) }
        var isSearchBarExpanded by remember { mutableStateOf(false) }

        val useNavigationRail = windowSizeClass.windowWidthSizeClass != WindowWidthSizeClass.COMPACT

        if (useNavigationRail) {
            // Mode paysage ou écran large (Medium/Expanded)
            Row {
                // Side Navigation (NavigationRail)
                NavigationRail {
                    if (currentDestination?.hasRoute<DestProfil>() == false) {
                        NavigationRailItem(
                            icon = {
                                Icon(Icons.Rounded.Star, contentDescription = "Films")
                            },
                            label = { Text("Films") },
                            selected = currentDestination.hasRoute<DestFilms>(),
                            onClick = {
                                navController.navigate(DestFilms())
                                searchText = ""
                            }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        NavigationRailItem(
                            icon = {
                                Icon(Icons.Rounded.Notifications, contentDescription = "Séries")
                            },
                            label = { Text("Séries") },
                            selected = currentDestination.hasRoute<DestSeries>(),
                            onClick = {
                                navController.navigate(DestSeries())
                                searchText = ""
                            }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        NavigationRailItem(
                            icon = {
                                Icon(Icons.Rounded.Face, contentDescription = "Acteurs")
                            },
                            label = { Text("Acteurs") },
                            selected = currentDestination.hasRoute<DestActeurs>(),
                            onClick = {
                                navController.navigate(DestActeurs())
                                searchText = ""
                            }
                        )
                    }
                }
                Scaffold(
                    floatingActionButton = {
                        if (currentDestination != null) {
                            if (!currentDestination.hasRoute<DestProfil>() && !currentDestination.hasRoute<Film>() && !currentDestination.hasRoute<Serie>()) {
                                if (!isSearchBarExpanded) {
                                    // Bouton flottant s'affiche quand la barre de recherche est réduite
                                    FloatingActionButton(
                                        onClick = {
                                            isSearchBarExpanded = true // Activer la SearchBar
                                            isSearching = true
                                        },
                                        content = {
                                            Icon(
                                                Icons.Rounded.Search,
                                                contentDescription = "Rechercher"
                                            )
                                        },
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }
                        }
                    },

                    topBar = {
                        if (currentDestination != null) {
                            if (!currentDestination.hasRoute<DestProfil>() && !currentDestination.hasRoute<Film>() && !currentDestination.hasRoute<Serie>()) {
                                // barre de recherche grande lorsqu'on effectue une nouvelle recherche
                                if (isSearchBarExpanded) {
                                    SearchBar(
                                        query = searchText,
                                        onQueryChange = { searchText = it },
                                        onSearch = {
                                            when {
                                                currentDestination.hasRoute<DestFilms>() -> viewmodel.searchMovies(
                                                    it
                                                )

                                                currentDestination.hasRoute<DestSeries>() -> viewmodel.searchSeries(
                                                    it
                                                )

                                                currentDestination.hasRoute<DestActeurs>() -> viewmodel.searchActeurs(
                                                    it
                                                )
                                            }
                                            isSearching = false
                                        },
                                        active = isSearching,
                                        onActiveChange = { isSearching = it },
                                        placeholder = { Text("Rechercher...") },
                                        leadingIcon = {
                                            Icon(
                                                Icons.Rounded.Search,
                                                contentDescription = "Icône de recherche"
                                            )
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(8.dp)
                                    ) {}
                                }
                            }
                        }

                    },

                ) { innerPadding ->
                    NavigationContent(
                        navController = navController,
                        viewmodel = viewmodel,
                        windowSizeClass = windowSizeClass,
                        innerPadding = innerPadding
                    )
                }
            }
        }else{

            // Mode portrait ou écran étroit (Compact)
            Scaffold(
                topBar = {
                    if (currentDestination != null) {
                        if (!currentDestination.hasRoute<DestProfil>() && !currentDestination.hasRoute<Film>() && !currentDestination.hasRoute<Serie>()) {
                            SearchBar(
                                query = searchText,
                                onQueryChange = { searchText = it },
                                onSearch = {
                                    if (currentDestination.hasRoute<DestFilms>()){
                                        viewmodel.searchMovies(it)
                                    }
                                    if (currentDestination.hasRoute<DestSeries>()){
                                        viewmodel.searchSeries(it)
                                    }
                                    if (currentDestination.hasRoute<DestActeurs>()){
                                        viewmodel.searchActeurs(it)
                                    }
                                    isSearching = false
                                },
                                active = isSearching,
                                onActiveChange = { isSearching = it },
                                placeholder = { Text("Rechercher...") },
                                leadingIcon = {
                                    Icon(Icons.Rounded.Search, contentDescription = "Icône de recherche")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ){

                            }
                        }
                    }
                },
                bottomBar = {
                    if (currentDestination?.hasRoute<DestProfil>() == false) {
                        NavigationBar {
                            NavigationBarItem(
                                icon = {
                                    Icon(Icons.Rounded.Star, contentDescription = "Films")
                                },
                                label = { Text("Films") },
                                selected = currentDestination.hasRoute<DestFilms>(),
                                onClick = {
                                    navController.navigate(DestFilms())
                                    searchText = ""
                                }
                            )
                            NavigationBarItem(
                                icon = {
                                    Icon(Icons.Rounded.PlayArrow, contentDescription = "Séries")
                                },
                                label = { Text("Séries") },
                                selected = currentDestination.hasRoute<DestSeries>(),
                                onClick = {
                                    navController.navigate(DestSeries())
                                    searchText = ""
                                }
                            )
                            NavigationBarItem(
                                icon = {
                                    Icon(Icons.Rounded.Face, contentDescription = "Acteurs")
                                },
                                label = { Text("Acteurs") },
                                selected = currentDestination.hasRoute<DestActeurs>(),
                                onClick = {
                                    navController.navigate(DestActeurs())
                                    searchText = ""
                                }
                            )
                        }
                    }
                }

            ) { innerPadding ->
                NavigationContent(
                    navController = navController,
                    viewmodel = viewmodel,
                    windowSizeClass = windowSizeClass,
                    innerPadding = innerPadding
                )
            }
        }



    }

    /**
     * Configure la navigation de l'application en définissant les différentes destinations
     * et leurs composables associés.
     */
    @Composable
    fun NavigationContent(
        navController: NavHostController,
        viewmodel: MainViewModel,
        windowSizeClass: WindowSizeClass,
        innerPadding: PaddingValues
    ) {
        NavHost(
            navController = navController,
            startDestination = DestProfil(),
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<DestProfil> {
                Greeting(
                    classes = windowSizeClass,
                    navController = navController
                )
            }
            composable<DestFilms> { DescFilms(navController, viewmodel, windowSizeClass) }
            composable<DestSeries> { DescSeries(navController, viewmodel, windowSizeClass) }
            composable<DestActeurs> { DescActeurs(viewmodel, windowSizeClass) }
            composable<Film> { backStackEntry ->
                val filmDetail: Film = backStackEntry.toRoute()
                FilmDetailFun(viewmodel, filmDetail.id)
            }
            composable<Serie> { backStackEntry ->
                val serieDetail: Serie = backStackEntry.toRoute()
                SerieDetailFun(viewmodel, serieDetail.id)
            }
        }
    }


}


