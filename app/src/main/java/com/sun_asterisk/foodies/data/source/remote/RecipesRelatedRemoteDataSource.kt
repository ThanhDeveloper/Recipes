package com.sun_asterisk.foodies.data.source.remote

import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.model.RecipesRelatedEntry
import com.sun_asterisk.foodies.data.source.datasource.RecipesRelatedDataSource
import com.sun_asterisk.foodies.data.source.remote.fetchjson.GetJsonFromURL
import com.sun_asterisk.foodies.utils.Constant

class RecipesRelatedRemoteDataSource : RecipesRelatedDataSource.Remote {
    private var baseUrl = ""

    private object Holder {
        val INSTANCE = RecipesRelatedRemoteDataSource()
    }

    override fun getRecipesRelatedInfo(listener: OnFetchDataJsonListener<MutableList<RecipesRelated>>, ingredientName: String?) {
        baseUrl = Constant.BASE_URL + Constant.KEY_FIND_BY_INGREDIENT + ingredientName + "&" + Constant.BASE_NUMBER + Constant.BASE_API_KEY
        GetJsonFromURL(listener, RecipesRelatedEntry.OBJECT).execute(baseUrl)
    }

    companion object {
        val instance: RecipesRelatedRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
