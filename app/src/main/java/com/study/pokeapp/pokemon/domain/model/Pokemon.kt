package com.study.pokeapp.pokemon.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<TypeSlot>,
    val sprites: Sprites
)
