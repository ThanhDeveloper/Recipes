package com.sun_asterisk.foodies.data.source.repository

import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.source.datasource.RecipesRelatedDataSource
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.remote.RecipesRelatedRemoteDataSource

class RecipesRelatedRepository private constructor(private val remote: RecipesRelatedDataSource.Remote) {

    private object Holder {
        val INSTANCE = RecipesRelatedRepository(remote = RecipesRelatedRemoteDataSource.instance)
    }

    fun getRecipesRelatedInfo(listener: OnFetchDataJsonListener<MutableList<RecipesRelated>>, ingredientName: String?) {
        remote.getRecipesRelatedInfo(listener, ingredientName)
    }

    companion object {
        val instance: RecipesRelatedRepository by lazy { Holder.INSTANCE }
    }
}
