package com.sun_asterisk.foodies.screen.home

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.source.repository.RecipesRepository
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.repository.ProductRepository

class HomePresenter internal constructor(private val recipesRepository: RecipesRepository?,
                                         private val productRepository: ProductRepository? ) :
    HomeContract.Presenter {

    private var view: HomeContract.View? = null

    override fun setView(view: HomeContract.View?) {
        this.view = view
    }

    override fun getRecipes() {
        recipesRepository?.getRecipesInfo(object : OnFetchDataJsonListener<MutableList<Recipes>> {

            override fun onSuccess(data: MutableList<Recipes>) {
                view?.onGetRecipesSuccess(data)
            }

            override fun onError(exception: java.lang.Exception) {
                view?.onGetError(exception)
            }
        })
    }

    override fun getProduct() {
        productRepository?.getProductInfo(object : OnFetchDataJsonListener<MutableList<Product>> {

            override fun onSuccess(data: MutableList<Product>) {
                view?.onGetProductSuccess(data)
            }

            override fun onError(exception: java.lang.Exception) {
                view?.onGetError(exception)
            }
        })
    }
}
