package com.dobrucali.product24.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dobrucali.product24.R
import com.dobrucali.product24.adapters.ProductAdapter
import com.dobrucali.product24.data.entity.Price
import com.dobrucali.product24.data.entity.ProductsItem

@BindingAdapter("productListData")
fun bindProductRecyclerView(recyclerView: RecyclerView, data: List<ProductsItem>?) {
    val adapter = recyclerView.adapter as ProductAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("formattedPrice")
fun bindFormattedPrice(textView: TextView, price: Price) {
    textView.text = formattedPrice(price.value, price.currency)
}

@BindingAdapter("app:goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}
