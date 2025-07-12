package com.study.pokeapp.pokemon.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.pokeapp.pokemon.data.PokemonRepository
import com.study.pokeapp.pokemon.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    fun toggleFavorite(pokemon: Pokemon) {
        viewModelScope.launch {
            repository.toggleFavorite(pokemon)
        }
    }
}
