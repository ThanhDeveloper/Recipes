package com.sun_asterisk.foodies.screen.recipes_detail

import com.sun_asterisk.foodies.data.model.RecipesDetail
import com.sun_asterisk.foodies.utils.BasePresenter

class RecipesDetailContract {
    /**
     * View
     */
    interface View {
        fun onGetRecipesDetailSuccess(info: RecipesDetail?)
        fun onGetRecipesDetailError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getRecipesDetail(recipesID: Int?)
    }
}
