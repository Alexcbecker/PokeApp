package com.study.pokeapp.pokemon.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alexandercbecker.pokeapp.R
import com.study.pokeapp.pokemon.domain.model.Pokemon
import com.study.pokeapp.pokemon.domain.model.Sprites
import com.study.pokeapp.pokemon.domain.model.Type
import com.study.pokeapp.pokemon.domain.model.TypeSlot

@Composable
fun PokemonRowComponent(
    pokemon: Pokemon,
    onClick: () -> Unit,
    onToggleFavorite: (Pokemon) -> Unit
) {
    var isFavorite by remember(pokemon.id) { mutableStateOf(pokemon.favorite) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = pokemon.sprites.frontDefault,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.ic_pokeball),
            fallback = painterResource(R.drawable.ic_pokeball),
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = pokemon.name,
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {
                isFavorite = !isFavorite
                onToggleFavorite(pokemon.copy(favorite = isFavorite))
            }
        ) {
            Icon(
                painter = painterResource(
                    if (pokemon.favorite) R.drawable.ic_favorite
                    else R.drawable.ic_favorite_outlined
                ),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonRowComponentPreview() {
    PokemonRowComponent(
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
        onClick = {},
        onToggleFavorite = {}
    )
}
