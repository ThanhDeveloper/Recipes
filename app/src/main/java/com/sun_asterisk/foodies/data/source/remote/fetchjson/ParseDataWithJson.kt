package com.sun_asterisk.foodies.data.source.remote.fetchjson

import android.util.Log
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ParseDataWithJson {

    @Throws(Exception::class)
    fun getJsonFromUrl(urlString: String?): String? {
        val url = URL(urlString)
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            requestMethod = METHOD_GET
            connect()
        }
        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        val stringBuilder = StringBuilder()
        var line: String?
        while ( bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString()
    }

    fun parseJsonToData(jsonObject: JSONObject?, keyEntity: String): Any {
        val data = mutableListOf<Any>()
        try {
            val jsonArray = jsonObject?.getJSONArray(keyEntity)
            for (i in 0 until (jsonArray?.length() ?: 0)) {
                val jsonObjects = jsonArray?.getJSONObject(i)
                val item = ParseDataWithJson().parseJsonToObject(jsonObjects, keyEntity)
                item?.let { data.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    fun parseJsonToData(jsonObjectArray: JSONArray?, keyEntity: String): Any {
        val data = mutableListOf<Any>()
        try {
            for (i in 0 until (jsonObjectArray?.length() ?: 0)) {
                val jsonObjects = jsonObjectArray?.getJSONObject(i)
                val item = ParseDataWithJson().parseJsonToObject(jsonObjects, keyEntity)
                item?.let { data.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    fun parseJsonToData(jsonObject: JSONObject?, keyEntity: String, objectKey : String): Any? =
        try {
            if(objectKey == RecipesDetailEntry.OBJECT) {
                ParseDataWithJson().parseJsonToObject(jsonObject, keyEntity)
            } else null
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    private fun parseJsonToObject(jsonObject: JSONObject?, keyEntity: String) : Any? =
        try {
            jsonObject?.let {
                when(keyEntity) {
                    RecipesEntry.OBJECT -> ParseJson().recipesParseJson(jsonObject)
                    ProductEntry.OBJECT -> ParseJson().productParseJson(jsonObject)
                    RecipesRelatedEntry.OBJECT -> ParseJson().recipesRelatedParseJson(jsonObject)
                    ProductSearchEntry.OBJECT -> ParseJson().productSearchParseJson(jsonObject)
                    RecipesDetailEntry.OBJECT -> {
                        val ingredientList = ArrayList<String>()
                        val stepNumberList = ArrayList<String>()
                        val dishTypesJsonArray =  jsonObject.getJSONArray(RecipesDetailEntry.OBJECT_DISHES)
                        val ingredientJsonArray =  jsonObject.getJSONArray(RecipesDetailEntry.OBJECT_INGREDIENT)
                        val instructionJsonArray = jsonObject.getJSONArray(RecipesDetailEntry.OBJECT_INSTRUCTIONS)
                        val instructionJsonObject = instructionJsonArray.getJSONObject(0)
                        val stepJsonArray = instructionJsonObject.getJSONArray(RecipesDetailEntry.OBJECT_STEP)
                        val dotMark = ": "
                        val blank = " "
                        var dishTypes = "DishTypes: "
                        for(i in 0 until ingredientJsonArray.length()) {
                            ingredientList.add(
                                ingredientJsonArray.getJSONObject(i).getString(RecipesDetailEntry.OBJECT_INGREDIENT_NAME) + dotMark +
                                        ingredientJsonArray.getJSONObject(i).getString(RecipesDetailEntry.OBJECT_INGREDIENT_AMOUNT) + blank +
                                            ingredientJsonArray.getJSONObject(i).getString(RecipesDetailEntry.OBJECT_INGREDIENT_UNIT))
                        }
                        for(i in 0 until dishTypesJsonArray.length()) {
                            dishTypes += when (i) {
                                dishTypesJsonArray.length() - 1 -> dishTypesJsonArray[i].toString()
                                else -> dishTypesJsonArray[i].toString() + ", "
                            }
                        }
                        for(i in 0 until stepJsonArray.length()) {
                            stepNumberList.add(
                                stepJsonArray.getJSONObject(i).getInt(RecipesDetailEntry.OBJECT_INGREDIENT_NUMBER).toString() + dotMark +
                                        stepJsonArray.getJSONObject(i).getString(RecipesDetailEntry.OBJECT_INGREDIENT_STEP))
                        }
                        ParseJson().recipesDetailParseJson(jsonObject, dishTypes, ingredientList, stepNumberList) }
                    else -> null
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            null
        }

    companion object {
        private const val TIME_OUT = 15000
        private const val METHOD_GET = "GET"
    }
}
