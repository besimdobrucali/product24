package com.dobrucali.product24.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductResponse(

    @field:SerializedName("header")
	val header: Header? = null,

    @field:SerializedName("filters")
	val filters: List<String?>? = null,

    @field:SerializedName("products")
	val products: List<ProductsItem?>? = null
) : Parcelable