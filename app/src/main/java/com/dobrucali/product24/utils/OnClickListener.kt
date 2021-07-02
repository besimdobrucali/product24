package com.dobrucali.product24.utils

import com.dobrucali.product24.data.entity.ProductsItem

class OnClickListener(val clickListener: (product: ProductsItem) -> Unit) {
    fun onClick(product: ProductsItem) = clickListener(product)
}