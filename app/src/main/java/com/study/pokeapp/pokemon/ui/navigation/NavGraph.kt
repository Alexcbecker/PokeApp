package com.study.pokeapp.pokemon.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.pokeapp.pokemon.domain.model.Pokemon
import com.study.pokeapp.pokemon.ui.PokemonDetailScreen
import com.study.pokeapp.pokemon.ui.PokemonListScreen

@Composable
fun AppNavGraph(startDestination: String = Screen.List.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.List.route) {
            PokemonListScreen(
                onPokemonClick = { pokemon ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("pokemon", pokemon)
                    navController.navigate(Screen.Detail.route)
                }
            )
        }

        composable(Screen.Detail.route) { backStackEntry ->
            val pokemon =
                navController.previousBackStackEntry?.savedStateHandle?.get<Pokemon>("pokemon")

            if (pokemon != null) {
                PokemonDetailScreen(pokemon)
            }
        }
    }
}
