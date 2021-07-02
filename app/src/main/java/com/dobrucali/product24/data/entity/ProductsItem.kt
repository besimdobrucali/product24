package com.dobrucali.product24.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "product")
@Parcelize
data class ProductsItem(

    @PrimaryKey
    val id: Int? = null,

    @field:SerializedName("longDescription")
	val longDescription: String? = null,

    @field:SerializedName("color")
	val color: String? = null,

    @field:SerializedName("releaseDate")
	val releaseDate: Int? = null,

    @field:SerializedName("price")
	val price: Price? = null,

    @field:SerializedName("imageURL")
	val imageURL: String? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("available")
	val available: Boolean? = null,

    @field:SerializedName("rating")
	val rating: Double? = null,

    @field:SerializedName("description")
	val description: String? = null,

    @field:SerializedName("colorCode")
	val colorCode: String? = null,

    @field:SerializedName("type")
	val type: String? = null
) : Parcelable