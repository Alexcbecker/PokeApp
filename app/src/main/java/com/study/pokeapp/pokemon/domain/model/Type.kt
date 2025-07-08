package com.study.pokeapp.pokemon.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Type(
    val name: String
) : Parcelable
