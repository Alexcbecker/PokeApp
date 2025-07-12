package com.study.pokeapp.pokemon.data

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.study.pokeapp.pokemon.data.local.model.PokemonEntity
import com.study.pokeapp.pokemon.data.remote.model.PokemonResponse
import com.study.pokeapp.pokemon.data.remote.model.TypeSlotResponse
import com.study.pokeapp.pokemon.data.remote.model.SpritesResponse
import com.study.pokeapp.pokemon.data.remote.model.TypeResponse
import com.study.pokeapp.pokemon.domain.model.Pokemon
import com.study.pokeapp.pokemon.domain.model.Sprites
import com.study.pokeapp.pokemon.domain.model.Type
import com.study.pokeapp.pokemon.domain.model.TypeSlot

fun PokemonResponse.toEntity(moshi: Moshi): PokemonEntity {
    val typeAdapter = moshi.adapter<List<TypeSlotResponse>>(
        Types.newParameterizedType(List::class.java, TypeSlotResponse::class.java)
    )
    val spritesAdapter = moshi.adapter(SpritesResponse::class.java)

    return PokemonEntity(
        id = id,
        name = name.capitalize(Locale.current),
        typesJson = typeAdapter.toJson(types),
        spritesJson = spritesAdapter.toJson(sprites)
    )
}

fun PokemonEntity.toDomain(moshi: Moshi): Pokemon {
    val typeAdapter = moshi.adapter<List<TypeSlotResponse>>(
        Types.newParameterizedType(List::class.java, TypeSlotResponse::class.java)
    )
    val spritesAdapter = moshi.adapter(SpritesResponse::class.java)

    val typeSlots: List<TypeSlotResponse> = typeAdapter.fromJson(typesJson).orEmpty()
    val spritesResponse: SpritesResponse = spritesAdapter.fromJson(spritesJson) ?: SpritesResponse.EMPTY

    return Pokemon(
        id = id,
        name = name,
        types = typeSlots.map { it.toDomain() },
        sprites = spritesResponse.toDomain(),
        favorite = favorite
    )
}

fun TypeSlotResponse.toDomain(): TypeSlot {
    return TypeSlot(
        slot = slot,
        type = type.toDomain()
    )
}

fun TypeResponse.toDomain(): Type {
    return Type(name = name)
}

fun SpritesResponse.toDomain(): Sprites {
    return Sprites(
        backDefault = backDefault,
        backFemale = backFemale,
        backShiny = backShiny,
        backShinyFemale = backShinyFemale,
        frontDefault = frontDefault,
        frontFemale = frontFemale,
        frontShiny = frontShiny,
        frontShinyFemale = frontShinyFemale
    )
}

fun Pokemon.toEntity(moshi: Moshi): PokemonEntity {
    val typeAdapter = moshi.adapter<List<TypeSlotResponse>>(
        Types.newParameterizedType(List::class.java, TypeSlotResponse::class.java)
    )
    val spritesAdapter = moshi.adapter(SpritesResponse::class.java)

    val typeSlotsResponse = types.mapIndexed { index, typeSlot ->
        TypeSlotResponse(
            slot = index,
            type = TypeResponse(name = typeSlot.type.name)
        )
    }

    val spritesResponse = SpritesResponse(
        backDefault = sprites.backDefault,
        backFemale = sprites.backFemale,
        backShiny = sprites.backShiny,
        backShinyFemale = sprites.backShinyFemale,
        frontDefault = sprites.frontDefault,
        frontFemale = sprites.frontFemale,
        frontShiny = sprites.frontShiny,
        frontShinyFemale = sprites.frontShinyFemale
    )

    return PokemonEntity(
        id = id,
        name = name,
        typesJson = typeAdapter.toJson(typeSlotsResponse),
        spritesJson = spritesAdapter.toJson(spritesResponse),
        favorite = favorite
    )
}


