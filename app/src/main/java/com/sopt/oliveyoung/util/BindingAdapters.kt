package com.sopt.oliveyoung.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.sopt.oliveyoung.R
import java.text.DecimalFormat

@BindingAdapter(value = ["price", "needsUnit"], requireAll = false)
fun TextView.setPriceFormat(price: Number?, needsUnit: Boolean = false) {
    val formattedPrice = DecimalFormat("#,###").format(price ?: 0)
    text = if (needsUnit) String.format(context.getString(R.string.detail_price_won_format),
        formattedPrice) else formattedPrice
}