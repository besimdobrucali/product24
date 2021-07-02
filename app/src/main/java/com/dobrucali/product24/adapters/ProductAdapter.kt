package com.dobrucali.product24.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dobrucali.product24.data.entity.AvailabilityType
import com.dobrucali.product24.data.entity.ProductsItem
import com.dobrucali.product24.databinding.ItemProductAvailableBinding
import com.dobrucali.product24.databinding.ItemProductNotAvailableBinding
import com.dobrucali.product24.utils.OnClickListener

class ProductAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<ProductsItem, BaseViewHolder>(ProductDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            AvailabilityType.NOT_AVAILABLE.ordinal -> {
                NotAvailableItemViewHolder(ItemProductNotAvailableBinding.inflate(LayoutInflater.from(parent.context)))
            }
            else -> {
                 AvailableItemViewHolder(ItemProductAvailableBinding.inflate(LayoutInflater.from(parent.context)))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position].available) {
            true -> AvailabilityType.AVAILABLE.ordinal
            else -> AvailabilityType.NOT_AVAILABLE.ordinal
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val product = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(product)
        }
        holder.bind(product)
    }

}