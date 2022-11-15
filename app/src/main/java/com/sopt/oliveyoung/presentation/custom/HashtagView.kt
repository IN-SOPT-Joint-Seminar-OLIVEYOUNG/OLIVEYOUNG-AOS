package com.sopt.oliveyoung.presentation.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.sopt.oliveyoung.databinding.ItemProductTypeBinding

class HashtagView(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    private lateinit var inflater: LayoutInflater

    init {
        if (!::inflater.isInitialized)
            inflater = LayoutInflater.from(context)
        orientation = HORIZONTAL // TODO delete
    }

    fun setHashtag(hashtag: List<String>) {
        this.removeAllViews()
        for (i in hashtag.indices) {
            val binding = ItemProductTypeBinding.inflate(inflater, this, false)
            binding.tvProductTypeName.text = hashtag[i]
            addView(binding.root)
        }
    }
}
