package com.sun_asterisk.foodies.data.source.datasource

import com.sun_asterisk.foodies.data.model.RecipesDetail
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener

interface RecipesDetailDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getRecipesDetailInfo(
            listener: OnFetchDataJsonListener<RecipesDetail>, recipesID: Int?)
    }
}
