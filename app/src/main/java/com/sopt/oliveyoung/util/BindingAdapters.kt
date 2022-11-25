package com.sopt.oliveyoung.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.sopt.oliveyoung.R
import java.text.DecimalFormat

@BindingAdapter(value = ["price", "needsUnit"], requireAll = false)
fun TextView.setPriceFormat(price: Number?, needsUnit: Boolean = false) {
    val formattedPrice = DecimalFormat("#,###").format(price ?: 0)
    text = if (needsUnit) String.format(
        context.getString(R.string.detail_price_won_format),
        formattedPrice
    ) else formattedPrice
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    load(imageUrl)
}

@BindingAdapter("isSelected")
fun View.setSelected(isSelected: Boolean?) {
    if (isSelected == null) return
    this.isSelected = isSelected
}

@BindingAdapter("visibility")
fun View.setVisibility(isVisible: Boolean?) {
    visibility = if (isVisible == false) View.VISIBLE else View.GONE
}