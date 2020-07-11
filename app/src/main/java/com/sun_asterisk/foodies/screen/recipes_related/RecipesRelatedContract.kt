package com.sun_asterisk.foodies.screen.home

import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.utils.BasePresenter

class RecipesRelatedContract {
    /**
     * View
     */
    interface View {
        fun onGetRecipesRelatedSuccess(info: MutableList<RecipesRelated>?)
        fun onGetRecipesRelatedError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getRecipesRelated(ingredientName: String?)
    }
}
