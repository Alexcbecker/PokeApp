package com.study.pokeapp.pokemon.ui.navigation

sealed class Screen(val route: String) {
    object List : Screen("pokemon_list")
    object Detail : Screen("pokemon_detail")
}
