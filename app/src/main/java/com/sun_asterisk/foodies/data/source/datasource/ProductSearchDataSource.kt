package com.sun_asterisk.foodies.data.source.datasource

import com.sun_asterisk.foodies.data.model.ProductSearch
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener

class ProductSearchDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getProductSearchInfo(listener: OnFetchDataJsonListener<MutableList<ProductSearch>>, productName: String?)
    }
}
