package com.dobrucali.product24.utils

import java.text.NumberFormat
import java.util.*

fun formattedPrice(value: Double?, currency: String?): String {
    return if (value != null && currency != null){
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance(currency)
        format.format(value)
    } else ""
}