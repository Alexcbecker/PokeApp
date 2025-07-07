package com.study.pokeapp.pokemon.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.study.pokeapp.pokemon.data.remote.model.SpritesResponse
import com.study.pokeapp.pokemon.data.remote.model.TypeSlotResponse
import javax.inject.Inject

@ProvidedTypeConverter
class PokemonConverters @Inject constructor(moshi: Moshi) {

    private val typeListAdapter = moshi.adapter<List<TypeSlotResponse>>(
        Types.newParameterizedType(List::class.java, TypeSlotResponse::class.java)
    )

    private val spritesAdapter = moshi.adapter(SpritesResponse::class.java)

    @TypeConverter
    fun fromTypeList(value: List<TypeSlotResponse>): String = typeListAdapter.toJson(value)

    @TypeConverter
    fun toTypeList(value: String): List<TypeSlotResponse> = typeListAdapter.fromJson(value).orEmpty()

    @TypeConverter
    fun fromSprites(value: SpritesResponse): String = spritesAdapter.toJson(value)

    @TypeConverter
    fun toSprites(value: String): SpritesResponse = spritesAdapter.fromJson(value) ?: SpritesResponse.EMPTY
}
