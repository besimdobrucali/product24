package com.dobrucali.product24.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Header(

	@field:SerializedName("headerDescription")
	val headerDescription: String? = null,

	@field:SerializedName("headerTitle")
	val headerTitle: String? = null
) : Parcelable