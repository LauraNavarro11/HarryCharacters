package com.example.miharrypotter

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/characters")
    suspend fun getcharacters():Response<List<CharactersResponse>>
    @GET("api/character/{id}")
    suspend fun getCharacterDetail(@Path("id") superHeroId: String): Response<List<CharactersResponse>>


}