package com.study.pokeapp.pokemon.data.remote.model

data class SpritesResponse(
    val backDefault: String? = null,
    val backFemale: String? = null,
    val backShiny: String? = null,
    val backShinyFemale: String? = null,
    val frontDefault: String? = null,
    val frontFemale: String? = null,
    val frontShiny: String? = null,
    val frontShinyFemale: String? = null,
) {
    companion object {
        val EMPTY = SpritesResponse()
    }
}
