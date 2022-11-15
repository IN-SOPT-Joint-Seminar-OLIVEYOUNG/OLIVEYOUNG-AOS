package com.sopt.oliveyoung.presentation

import android.os.Bundle
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivityDetailBinding
import com.sopt.oliveyoung.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.viewHashtag.setHashtag(listOf("립밤", "핸드크림", "틴트", "쿠션", "마스크팩"))
    }
}