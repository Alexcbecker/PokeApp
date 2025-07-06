package com.study.pokeapp.pokemon.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val typesJson: String,
    val spritesJson: String
)
