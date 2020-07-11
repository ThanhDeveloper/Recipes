package com.sun_asterisk.foodies.screen.home.layout_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.Ingredient
import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.source.remote.download_image.DownloadImageRecipes
import com.sun_asterisk.foodies.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_recipes_related_layout.view.*

class RecipesRelatedAdapter : RecyclerView.Adapter<RecipesRelatedAdapter.RecipesRelatedViewHolder>() {

    private val recipesRelated = mutableListOf<RecipesRelated>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<RecipesRelated>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesRelatedViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_recipes_related_layout, parent, false)
        return RecipesRelatedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipesRelatedViewHolder, position: Int) {
        holder.bindData(recipesRelated[position])
    }

    override fun getItemCount() = recipesRelated.size

    fun updateData(data: List<RecipesRelated>) {
        recipesRelated.clear()
        recipesRelated.addAll(data)
        notifyDataSetChanged()
    }

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<RecipesRelated>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    inner class RecipesRelatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(recipesRelated: RecipesRelated) {
            itemView.run {
                textRecipesRelated.text = recipesRelated.name
                textRecipesRelatedQuality.text = recipesRelated.like.toString()
                DownloadImageRecipes {
                    imageRecipesRelatedCustom.setImageBitmap(it)
                }.execute(recipesRelated.image)
                setOnClickListener { onItemClickListener?.onItemClickListener(recipesRelated) }
            }
        }
    }
}
