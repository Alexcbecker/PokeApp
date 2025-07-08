package com.study.pokeapp.pokemon.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeSlot(
    val slot: Int,
    val type: Type
) : Parcelable
