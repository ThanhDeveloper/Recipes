package com.sun_asterisk.foodies.data.source.remote

import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.model.RecipesEntry
import com.sun_asterisk.foodies.data.source.datasource.RecipesDataSource
import com.sun_asterisk.foodies.data.source.remote.fetchjson.GetJsonFromURL
import com.sun_asterisk.foodies.utils.Constant

class RecipesRemoteDataSource : RecipesDataSource.Remote {
    private var baseUrl =
        Constant.BASE_URL + Constant.BASE_RECIPES_RANDOM + Constant.BASE_NUMBER + Constant.BASE_API_KEY

    private object Holder {
        val INSTANCE = RecipesRemoteDataSource()
    }

    override fun getRecipesInfo(listener: OnFetchDataJsonListener<MutableList<Recipes>>) {
        GetJsonFromURL(listener, RecipesEntry.OBJECT).execute(baseUrl)
    }

    companion object {
        val instance: RecipesRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
