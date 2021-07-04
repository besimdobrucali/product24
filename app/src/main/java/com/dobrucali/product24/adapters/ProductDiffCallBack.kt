package com.dobrucali.product24.adapters

import androidx.recyclerview.widget.DiffUtil
import com.dobrucali.product24.data.entity.ProductsItem

object ProductDiffCallBack : DiffUtil.ItemCallback<ProductsItem>() {
    override fun areItemsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
        return oldItem == newItem
    }
}