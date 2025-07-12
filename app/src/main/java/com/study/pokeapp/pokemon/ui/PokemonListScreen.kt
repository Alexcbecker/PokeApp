package com.study.pokeapp.pokemon.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.study.pokeapp.pokemon.domain.model.Pokemon
import com.study.pokeapp.pokemon.ui.components.LoadingComponent
import com.study.pokeapp.pokemon.ui.components.PokemonListComponent

@Composable
fun PokemonListScreen(
    pokemonListViewModel: PokemonListViewModel = hiltViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
    onPokemonClick: (Pokemon) -> Unit
) {
    val isLoading by pokemonListViewModel.isLoading.collectAsState()
    val pokemons = pokemonListViewModel.pokemonFlow.collectAsLazyPagingItems()

    if (isLoading) {
        LoadingComponent()
    } else {
        PokemonListComponent(
            pokemons = pokemons,
            onPokemonClick = onPokemonClick,
            onToggleFavorite = { pokemon -> favoritesViewModel.toggleFavorite(pokemon) }
        )
    }
}
