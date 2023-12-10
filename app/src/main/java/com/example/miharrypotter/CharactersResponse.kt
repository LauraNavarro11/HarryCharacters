package com.example.miharrypotter

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("name") var name: String,
    @SerializedName("house") var house: String,
    @SerializedName("image") var image: String,
    @SerializedName("ancestry") var ancestry: String,
    @SerializedName("id") var id: String,
    @SerializedName("yearOfBirth") var yearOfBirth: String,
    @SerializedName("patronus") var patronus: String,
    @SerializedName("actor") var actor: String,
    @SerializedName("eyeColour") var eyeColour: String


)