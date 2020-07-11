package com.sun_asterisk.foodies.data.source.remote

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.model.ProductEntry
import com.sun_asterisk.foodies.data.source.datasource.ProductDataSource
import com.sun_asterisk.foodies.data.source.remote.fetchjson.GetJsonFromURL
import com.sun_asterisk.foodies.utils.Constant

class ProductRemoteDataSource : ProductDataSource.Remote {
    private var baseUrl = Constant.BASE_URL +
            Constant.BASE_PRODUCT_SEARCH + Constant.BASE_QUERY + Constant.BASE_NUMBER + Constant.BASE_API_KEY

    private object Holder {
        val INSTANCE = ProductRemoteDataSource()
    }

    override fun getProductInfo(listener: OnFetchDataJsonListener<MutableList<Product>>) {
        GetJsonFromURL(listener, ProductEntry.OBJECT).execute(baseUrl)
    }

    companion object {
        val instance: ProductRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
