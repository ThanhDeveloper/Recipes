package com.sun_asterisk.foodies.data.source.datasource

import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener

interface RecipesRelatedDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getRecipesRelatedInfo(listener: OnFetchDataJsonListener<MutableList<RecipesRelated>>, ingredientName: String?)
    }
}
