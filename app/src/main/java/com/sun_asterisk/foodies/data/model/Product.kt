package com.sun_asterisk.foodies.data.model

data class Product(
    var name: String,
    var image: String
)

object ProductEntry {
    const val OBJECT = "products"
    const val TITTLE = "title"
    const val IMAGE = "image"
}
