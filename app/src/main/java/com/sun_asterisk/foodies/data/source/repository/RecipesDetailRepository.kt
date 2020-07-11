package com.sun_asterisk.foodies.data.source.repository

import com.sun_asterisk.foodies.data.model.RecipesDetail
import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.source.datasource.RecipesDetailDataSource
import com.sun_asterisk.foodies.data.source.datasource.RecipesRelatedDataSource
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.remote.RecipesDetailRemoteDataSource
import com.sun_asterisk.foodies.data.source.remote.RecipesRelatedRemoteDataSource

class RecipesDetailRepository private constructor(private val remote: RecipesDetailDataSource.Remote) {

    private object Holder {
        val INSTANCE = RecipesDetailRepository(remote = RecipesDetailRemoteDataSource.instance)
    }

    fun getRecipesDetailInfo(listener: OnFetchDataJsonListener<RecipesDetail>, recipesID: Int?) {
        remote.getRecipesDetailInfo(listener, recipesID)
    }

    companion object {
        val instance: RecipesDetailRepository by lazy { Holder.INSTANCE }
    }
}
