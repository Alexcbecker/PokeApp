package com.study.pokeapp.pokemon.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.study.pokeapp.pokemon.ui.components.LoadingComponent
import com.study.pokeapp.pokemon.ui.components.PokemonListComponent

@Composable
fun PokemonListScreen(viewModel: PokemonListViewModel = viewModel()) {
    val isLoading by viewModel.isLoading.collectAsState()
    val pokemons = viewModel.pokemonFlow.collectAsLazyPagingItems()

    if (isLoading) {
        LoadingComponent()
    } else {
        PokemonListComponent(pokemons = pokemons)
    }
}
