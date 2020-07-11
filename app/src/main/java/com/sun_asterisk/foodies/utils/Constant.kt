package com.sun_asterisk.foodies.utils

import com.sun_asterisk.foodies.BuildConfig

object Constant {
    const val BASE_URL = "https://api.spoonacular.com/"
    const val BASE_NUMBER = "number=10"
    const val BASE_API_KEY = "&apiKey=" + BuildConfig.API_KEY
    const val BASE_QUERY = "query=vegetable&"
    const val BASE_PRODUCT_SEARCH = "food/products/search?"
    const val KEY_INGREDIENT_NAME = "IngredientName"
    const val KEY_INGREDIENT_IMAGE = "IngredientResID"
    const val KEY_RECIPES_ID = "RecipesID"
    const val KEY_FIND_BY_INGREDIENT = "recipes/findByIngredients?ingredients="
    const val KEY_RECIPES = "recipes/"
    const val BASE_RECIPES_RANDOM = KEY_RECIPES + "random?"
    const val KEY_RECIPES_DETAIL = "/information?includeNutrition=false"
    const val BASE_QUERY_PRODUCT = "query="
}
