package com.sun_asterisk.foodies.data.model

data class RecipesRelated(
    var id: Int,
    var name: String,
    var image: String,
    var like: Int
)

object RecipesRelatedEntry {
    const val OBJECT = "related"
    const val ID = "id"
    const val TITTLE = "title"
    const val IMAGE = "image"
    const val LIKE = "likes"
}
