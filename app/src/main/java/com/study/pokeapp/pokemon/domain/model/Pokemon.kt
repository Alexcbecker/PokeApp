package com.study.pokeapp.pokemon.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<TypeSlot>,
    val sprites: Sprites
) : Parcelable
