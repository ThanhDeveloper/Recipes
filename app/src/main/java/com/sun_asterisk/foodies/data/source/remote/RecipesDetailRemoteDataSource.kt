package com.sun_asterisk.foodies.data.source.remote

import android.util.Log
import com.sun_asterisk.foodies.data.model.RecipesDetail
import com.sun_asterisk.foodies.data.model.RecipesDetailEntry
import com.sun_asterisk.foodies.data.source.datasource.ProductDataSource
import com.sun_asterisk.foodies.data.source.datasource.RecipesDetailDataSource
import com.sun_asterisk.foodies.data.source.remote.fetchjson.GetJsonFromURL
import com.sun_asterisk.foodies.utils.Constant

class RecipesDetailRemoteDataSource : RecipesDetailDataSource.Remote {
    private var baseUrl = ""

    private object Holder {
        val INSTANCE = RecipesDetailRemoteDataSource()
    }

    override fun getRecipesDetailInfo(listener: OnFetchDataJsonListener<RecipesDetail>, recipesID: Int?) {
        baseUrl =
            Constant.BASE_URL + Constant.KEY_RECIPES + recipesID.toString() + Constant.KEY_RECIPES_DETAIL + Constant.BASE_API_KEY
        GetJsonFromURL(listener, RecipesDetailEntry.OBJECT).execute(baseUrl)
    }

    companion object {
        val instance: RecipesDetailRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
