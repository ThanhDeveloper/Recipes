package com.sun_asterisk.foodies.data.model

data class RecipesDetail(
    var id: Int,
    var name: String,
    var image: String?,
    var dishTypes: String,
    var ingredient: ArrayList<String>,
    var step: ArrayList<String>
)

object RecipesDetailEntry {
    const val OBJECT = "Detail"
    const val ID = "id"
    const val TITTLE = "title"
    const val IMAGE = "image"
    const val OBJECT_DISHES = "dishTypes"
    const val OBJECT_INGREDIENT = "extendedIngredients"
    const val OBJECT_INSTRUCTIONS = "analyzedInstructions"
    const val OBJECT_STEP = "steps"
    const val OBJECT_INGREDIENT_NAME = "name"
    const val OBJECT_INGREDIENT_AMOUNT = "amount"
    const val OBJECT_INGREDIENT_UNIT = "unit"
    const val OBJECT_INGREDIENT_NUMBER = "number"
    const val OBJECT_INGREDIENT_STEP = "step"
}
