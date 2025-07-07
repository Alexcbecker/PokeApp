package com.study.pokeapp.pokemon.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.study.pokeapp.pokemon.domain.model.Pokemon
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.study.pokeapp.pokemon.domain.model.Sprites
import com.study.pokeapp.pokemon.domain.model.Type
import com.study.pokeapp.pokemon.domain.model.TypeSlot
import kotlinx.coroutines.flow.flowOf

@Composable
fun PokemonListComponent(pokemons: LazyPagingItems<Pokemon>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(
            pokemons.itemCount,
            key = pokemons.itemKey()
        ) { index ->
            pokemons[index]?.let { pokemon ->
                PokemonRowComponent(pokemon = pokemon)
                if (index < pokemons.itemSnapshotList.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp),
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonListComponentPreview() {
    PokemonListComponent(
        flowOf(
            PagingData.from(
                listOf(
                    Pokemon(
                        id = 1,
                        name = "Bulbasaur",
                        types = listOf(
                            TypeSlot(
                                slot = 1,
                                Type(
                                    name = "Grass"
                                )
                            )
                        ),
                        sprites = Sprites()
                    ),
                    Pokemon(
                        id = 2,
                        name = "Ivysaur",
                        types = listOf(
                            TypeSlot(
                                slot = 1,
                                Type(
                                    name = "Grass"
                                )
                            )
                        ),
                        sprites = Sprites()
                    )
                )
            )
        ).collectAsLazyPagingItems()
    )
}

