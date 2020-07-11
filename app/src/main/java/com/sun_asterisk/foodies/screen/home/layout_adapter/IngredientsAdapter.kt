package com.sun_asterisk.foodies.screen.home.layout_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.Ingredient
import com.sun_asterisk.foodies.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_layout.view.*

class IngredientsAdapter(private val ingredient: MutableList<Ingredient> = mutableListOf()) :
    RecyclerView.Adapter<IngredientsAdapter.IngredientViewHolder>() {

    private var onItemClickListener: OnItemRecyclerViewClickListener<Ingredient>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return IngredientViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bindData(ingredient[position])
    }

    override fun getItemCount() = ingredient.size

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Ingredient>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    inner class IngredientViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindData(ingredient: Ingredient) {
            itemView.run {
                textIngredientName.text = ingredient.name
                imageIngredient.setImageResource(ingredient.imageResId)
                setOnClickListener { onItemClickListener?.onItemClickListener(ingredient) }
            }
        }
    }
}
