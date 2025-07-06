package com.study.pokeapp.pokemon.data.remote.model

data class PokemonResponse(
    val id: Int,
    val name: String,
    val types: List<TypeSlotResponse>,
    val sprites: SpritesResponse
)
