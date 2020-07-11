package com.sun_asterisk.foodies.data.source.repository

import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.source.datasource.RecipesDataSource
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.remote.RecipesRemoteDataSource

class RecipesRepository private constructor(private val remote: RecipesDataSource.Remote) {

    private object Holder {
        val INSTANCE = RecipesRepository(remote = RecipesRemoteDataSource.instance)
    }

    fun getRecipesInfo(listener: OnFetchDataJsonListener<MutableList<Recipes>>) {
        remote.getRecipesInfo(listener)
    }

    companion object {
        val instance: RecipesRepository by lazy { Holder.INSTANCE }
    }
}
