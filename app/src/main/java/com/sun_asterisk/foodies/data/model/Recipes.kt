package com.sun_asterisk.foodies.data.model

data class Recipes(
    var name: String,
    var image: String
)

object RecipesEntry {
    const val OBJECT = "recipes"
    const val TITTLE = "title"
    const val IMAGE = "image"
}
