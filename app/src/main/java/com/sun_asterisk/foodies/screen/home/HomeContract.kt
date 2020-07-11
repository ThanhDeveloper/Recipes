package com.sun_asterisk.foodies.screen.home

import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.utils.BasePresenter

class HomeContract {
    /**
     * View
     */
    interface View {
        fun onGetRecipesSuccess(info: MutableList<Recipes>?)
        fun onGetError(exception: Exception?)
        fun onGetProductSuccess(info: MutableList<Product>?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getRecipes()
        fun getProduct()
    }
}
