package com.dobrucali.product24.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dobrucali.product24.data.entity.ProductsItem

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(product: ProductsItem)
}