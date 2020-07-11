package com.sun_asterisk.foodies.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.Ingredient
import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.source.repository.ProductRepository
import com.sun_asterisk.foodies.data.source.repository.RecipesRepository
import com.sun_asterisk.foodies.screen.home.layout_adapter.IngredientsAdapter
import com.sun_asterisk.foodies.screen.home.layout_adapter.ProductAdapter
import com.sun_asterisk.foodies.screen.home.layout_adapter.RecipesAdapter
import com.sun_asterisk.foodies.screen.recipes_related.RecipesRelatedFragment
import com.sun_asterisk.foodies.utils.Constant
import com.sun_asterisk.foodies.utils.OnItemRecyclerViewClickListener
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View, OnItemRecyclerViewClickListener<Ingredient> {

    private val recipesAdapter by lazy { RecipesAdapter() }
    private val productAdapter by lazy { ProductAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    private fun initCarousel() {
        val carouselImages = resources.obtainTypedArray(R.array.carousel_images)
        val imageListener =
            ImageListener { position, imageView ->
                imageView.setImageResource(
                    carouselImages.getResourceId(position, 0)
                )
            }
        carouselView.apply {
            setImageListener(imageListener)
            pageCount = carouselImages.length()
        }
        carouselImages.recycle()
    }

    private fun initIngredientsRecyclerView() {
        val ingredientsText = resources.getStringArray(R.array.ingredient_names)
        val ingredientsImages = resources.obtainTypedArray(R.array.ingredient_images)
        val ingredientList = mutableListOf<Ingredient>()
        for (i in ingredientsText.indices) {
            ingredientList.add(
                Ingredient(
                    ingredientsImages.getResourceId(i, 0),
                    ingredientsText[i]
                )
            )
        }
        ingredientsImages.recycle()
        val ingredientsAdapter = IngredientsAdapter(ingredientList).apply {
            registerItemRecyclerViewClickListener(this@HomeFragment)
        }
        recyclerIngredients.adapter = ingredientsAdapter
    }

    override fun onGetRecipesSuccess(info: MutableList<Recipes>?) {
        info?.let { recipesAdapter.updateData(it) }
    }

    override fun onGetError(exception: Exception?) {
        Toast.makeText(this.context, exception.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onGetProductSuccess(info: MutableList<Product>?) {
        info?.let { productAdapter.updateData(it) }
    }

    private fun initData() {
        val presenter = HomePresenter(RecipesRepository.instance, ProductRepository.instance)
        presenter.let {
            it.setView(this)
            it.getProduct()
            it.getRecipes()
        }
    }

    override fun onItemClickListener(item: Ingredient?) {
        val recipesRelatedFragment = RecipesRelatedFragment()
            .apply {
            arguments = bundleOf(
                Constant.KEY_INGREDIENT_IMAGE to item?.imageResId,
                Constant.KEY_INGREDIENT_NAME to item?.name
            )
        }
        openFragment(recipesRelatedFragment)
    }

    private fun openFragment(fragment: Fragment) {
      activity?.supportFragmentManager
        val transaction = fragmentManager?.beginTransaction()
        transaction?.apply {
            add(R.id.container,fragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun initView() {
        initCarousel()
        initIngredientsRecyclerView()
        recyclerRecipes.adapter = recipesAdapter
        recyclerProduct.adapter = productAdapter
    }
}
