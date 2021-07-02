package com.dobrucali.product24.adapters

import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.databinding.ItemProductAvailableBinding

class AvailableItemViewHolder(private var binding: ItemProductAvailableBinding) : BaseViewHolder(binding.root) {
    override fun bind(product: ProductsItem) {
        binding.productItem = product
        binding.executePendingBindings()
    }
}