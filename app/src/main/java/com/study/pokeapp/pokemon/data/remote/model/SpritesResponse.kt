package com.study.pokeapp.pokemon.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpritesResponse(
    @Json(name = "back_default") val backDefault: String? = null,
    @Json(name = "back_female") val backFemale: String? = null,
    @Json(name = "back_shiny") val backShiny: String? = null,
    @Json(name = "back_shiny_female") val backShinyFemale: String? = null,
    @Json(name = "front_default") val frontDefault: String? = null,
    @Json(name = "front_female") val frontFemale: String? = null,
    @Json(name = "front_shiny") val frontShiny: String? = null,
    @Json(name = "front_shiny_female") val frontShinyFemale: String? = null,
) {
    companion object {
        val EMPTY = SpritesResponse()
    }
}
