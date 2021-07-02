package com.dobrucali.product24.data.entity

import android.os.Parcelable
import com.dobrucali.product24.utils.formattedPrice
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("value")
	val value: Double? = null
) : Parcelable