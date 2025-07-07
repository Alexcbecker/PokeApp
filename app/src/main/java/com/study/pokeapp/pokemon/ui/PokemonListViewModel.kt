package com.study.pokeapp.pokemon.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.study.pokeapp.pokemon.data.PokemonRepository
import com.study.pokeapp.pokemon.data.bootstrap.PokemonSeeder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository,
    private val seeder: PokemonSeeder
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    val pokemonFlow = repository.getPokemons().cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
            seeder.seedIfNeeded()
            _isLoading.value = false
        }
    }
}
