package com.sun_asterisk.foodies.screen.home.layout_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.Product
import com.sun_asterisk.foodies.data.source.remote.download_image.DownloadImageRecipes
import kotlinx.android.synthetic.main.row_product_layout.view.*

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private val product = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_product_layout, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindData(product[position])
    }

    override fun getItemCount() = product.size

    fun updateData(data: List<Product>) {
        product.clear()
        product.addAll(data)
        notifyDataSetChanged()
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(product: Product) {
            itemView.run {
                textProductName.text = product.name
                DownloadImageRecipes {
                    imageProduct.setImageBitmap(it)
                }.execute(product.image)
            }
        }
    }
}
