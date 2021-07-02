package com.dobrucali.product24.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dobrucali.product24.utils.formattedPrice
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "price")
@Parcelize
data class Price(

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	val id: Int? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("value")
	val value: Double? = null
) : Parcelable