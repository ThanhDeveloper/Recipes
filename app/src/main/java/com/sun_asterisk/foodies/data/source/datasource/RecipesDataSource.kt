package com.sun_asterisk.foodies.data.source.datasource

import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener

interface RecipesDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getRecipesInfo(listener: OnFetchDataJsonListener<MutableList<Recipes>>)
    }
}
