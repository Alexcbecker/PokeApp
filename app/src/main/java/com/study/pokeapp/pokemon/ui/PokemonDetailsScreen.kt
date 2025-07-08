package com.study.pokeapp.pokemon.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.study.pokeapp.pokemon.domain.model.Pokemon

@Composable
fun PokemonDetailScreen(pokemon: Pokemon) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Name: ${pokemon.name}")
        Text(text = "Types: ${pokemon.types.joinToString { it.type.name }}")
        AsyncImage(
            model = pokemon.sprites.frontDefault,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}
