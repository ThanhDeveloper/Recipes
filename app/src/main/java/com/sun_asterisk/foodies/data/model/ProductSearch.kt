package com.sun_asterisk.foodies.data.model

data class ProductSearch(
    var name: String,
    var image: String
)

object ProductSearchEntry {
    const val OBJECT = "product_search"
    const val TITTLE = "title"
    const val IMAGE = "image"
}
