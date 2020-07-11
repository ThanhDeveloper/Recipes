package com.sun_asterisk.foodies.screen.home.layout_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.Ingredient
import com.sun_asterisk.foodies.data.model.Recipes
import com.sun_asterisk.foodies.data.source.remote.download_image.DownloadImageRecipes
import com.sun_asterisk.foodies.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_recipes_layout.view.*

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {
    private val recipes = mutableListOf<Recipes>()

    private var onItemClickListener: OnItemRecyclerViewClickListener<Recipes>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_recipes_layout, parent, false)
        return RecipesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.bindData(recipes[position])
    }

    override fun getItemCount() = recipes.size

    fun updateData(data: List<Recipes>) {
        recipes.clear()
        recipes.addAll(data)
        notifyDataSetChanged()
    }

    inner class RecipesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(recipes: Recipes) {
            itemView.run {
                textRecipesName.text = recipes.name
                DownloadImageRecipes {
                    imageRecipes.setImageBitmap(it)
                }.execute(recipes.image)
                setOnClickListener { onItemClickListener?.onItemClickListener(recipes) }
            }
        }
    }
}
