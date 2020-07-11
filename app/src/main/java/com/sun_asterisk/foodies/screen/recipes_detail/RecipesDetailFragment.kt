package com.sun_asterisk.foodies.screen.recipes_detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.RecipesDetail
import com.sun_asterisk.foodies.data.source.remote.download_image.DownloadImageRecipes
import com.sun_asterisk.foodies.data.source.repository.RecipesDetailRepository
import com.sun_asterisk.foodies.screen.home.layout_adapter.RecipesRelatedAdapter
import com.sun_asterisk.foodies.utils.Constant
import com.sun_asterisk.foodies.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_recipes_detail.*


class RecipesDetailFragment : Fragment(), RecipesDetailContract.View,
    OnItemRecyclerViewClickListener<RecipesDetail> {

    private var recipesID: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        //initView()
        buttonBackDetail.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                remove(this@RecipesDetailFragment)
                commit()
            }
        }
    }

    private fun initData() {
        arguments?.let { recipesID = it.getInt(Constant.KEY_RECIPES_ID, 0) }
        Log.i("values",recipesID.toString())
        val presenter = RecipesDetailPresenter(RecipesDetailRepository.instance)
        presenter.let {
            it.setView(this)
            it.getRecipesDetail(recipesID)
        }
    }

    private fun initView() {
    }


    override fun onGetRecipesDetailSuccess(info: RecipesDetail?) {
        var ingredients = ""
        var instructions = ""
        info?.let {
            Log.i("values",info.toString())
            textRecipesDetailName.text = it.name
            textRecipesDishTypes.text = it.dishTypes
            for(i in 0 until it.ingredient.size) {
                ingredients += getString(R.string.text_ingredient_detail,it.ingredient[i])
            }
            for(i in 0 until it.step.size) {
                instructions += getString(R.string.text_instruction_detail,it.step[i])
            }
            textRecipesDetailIngredients.text = ingredients
            textRecipesDetailTutorials.text = instructions
            it.image?.let {
                DownloadImageRecipes {
                    imageRecipesDetail.setImageBitmap(it)
                }.execute(it)
            }
        }
    }

    override fun onGetRecipesDetailError(exception: Exception?) {
        Toast.makeText(this.context, exception.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: RecipesDetail?) {

    }
}
