package com.study.pokeapp.core.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://pokeapi.co/api/v2/"

object RetrofitBuilder {
    fun buildRetrofit(moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
}
