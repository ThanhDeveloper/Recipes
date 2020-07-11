package com.sun_asterisk.foodies.data.source.remote

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.model.ProductSearchEntry
import com.sun_asterisk.foodies.data.source.datasource.ProductSearchDataSource
import com.sun_asterisk.foodies.data.source.remote.fetchjson.GetJsonFromURL
import com.sun_asterisk.foodies.utils.Constant

class ProductSearchRemoteDataSource : ProductSearchDataSource.Remote {
    private var baseUrl = ""


    private object Holder {
        val INSTANCE = ProductSearchRemoteDataSource()
    }

    override fun getProductSearchInfo(listener: OnFetchDataJsonListener<MutableList<Product>>, productName: String?) {
        baseUrl = Constant.BASE_URL +
                Constant.BASE_PRODUCT_SEARCH + Constant.BASE_QUERY_PRODUCT + productName.toString() + "&" + Constant.BASE_NUMBER + Constant.BASE_API_KEY
        GetJsonFromURL(listener, ProductSearchEntry.OBJECT).execute(baseUrl)
    }

    companion object {
        val instance: ProductSearchRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
