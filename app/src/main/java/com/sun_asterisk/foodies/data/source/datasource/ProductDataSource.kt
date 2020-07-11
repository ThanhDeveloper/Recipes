package com.sun_asterisk.foodies.data.source.datasource

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener

interface ProductDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getProductInfo(listener: OnFetchDataJsonListener<MutableList<Product>>)
    }
}
