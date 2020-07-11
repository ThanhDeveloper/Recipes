package com.sun_asterisk.foodies.data.source.repository

import com.sun_asterisk.foodies.data.model.ProductSearch
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.remote.ProductSearchRemoteDataSource

class ProductSearchRepository {
    private object Holder {
        val INSTANCE = ProductSearchRepository(ProductSearchRemoteDataSource.instance)
    }

    fun getProductSearchInfo(listener: OnFetchDataJsonListener<MutableList<ProductSearch>>) {
        remote.getProductSearchInfo(listener)
    }

    companion object {
        val instance: ProductSearchRepository by lazy { Holder.INSTANCE }
    }
}