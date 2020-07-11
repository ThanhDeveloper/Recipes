package com.sun_asterisk.foodies.data.source.remote.fetchjson

import com.sun_asterisk.foodies.data.model.*
import org.json.JSONObject

class ParseJson {

    fun recipesParseJson(jsonObject: JSONObject) =
        Recipes(
            name = jsonObject.getString(RecipesEntry.TITTLE),
            image = jsonObject.getString(RecipesEntry.IMAGE)
        )

    fun productParseJson(jsonObject: JSONObject) =
        Product(
            name = jsonObject.getString(ProductEntry.TITTLE),
            image = jsonObject.getString(ProductEntry.IMAGE)
        )

    fun recipesRelatedParseJson(jsonObject: JSONObject) =
        RecipesRelated(
            id = jsonObject.getInt(RecipesRelatedEntry.ID),
            name = jsonObject.getString(RecipesRelatedEntry.TITTLE),
            image = jsonObject.getString(RecipesRelatedEntry.IMAGE),
            like = jsonObject.getInt(RecipesRelatedEntry.LIKE)
        )

    fun recipesDetailParseJson(jsonObject: JSONObject, dishTypes: String, ingredientList: ArrayList<String>, stepNumberList: ArrayList<String>) =
        RecipesDetail(
            id = jsonObject.getInt(RecipesDetailEntry.ID),
            name = jsonObject.getString(RecipesDetailEntry.TITTLE),
            image = jsonObject.getString(RecipesDetailEntry.IMAGE),
            dishTypes = dishTypes,
            ingredient= ingredientList,
            step= stepNumberList
        )

    fun productSearchParseJson(jsonObject: JSONObject) =
        ProductSearch(
            name = jsonObject.getString(ProductSearchEntry.TITTLE),
            image = jsonObject.getString(ProductSearchEntry.IMAGE)
        )
}
