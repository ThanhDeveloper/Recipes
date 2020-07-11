package com.sun_asterisk.foodies.screen.recipes_detail

import com.sun_asterisk.foodies.data.model.RecipesDetail
import com.sun_asterisk.foodies.data.source.remote.OnFetchDataJsonListener
import com.sun_asterisk.foodies.data.source.repository.RecipesDetailRepository

class RecipesDetailPresenter internal constructor(private val recipesDetailRepository: RecipesDetailRepository?) :
    RecipesDetailContract.Presenter {

    private var view: RecipesDetailContract.View? = null

    override fun setView(view: RecipesDetailContract.View?) {
        this.view = view
    }

    override fun getRecipesDetail(recipesID: Int?) {
        recipesDetailRepository?.getRecipesDetailInfo(object : OnFetchDataJsonListener<RecipesDetail> {

            override fun onSuccess(data: RecipesDetail) {
                view?.onGetRecipesDetailSuccess(data)
            }

            override fun onError(exception: java.lang.Exception) {
                view?.onGetRecipesDetailError(exception)
            }
        }, recipesID)
    }
}
