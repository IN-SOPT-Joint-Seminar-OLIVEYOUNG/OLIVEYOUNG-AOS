package com.sopt.oliveyoung.presentation

import android.os.Bundle
import com.sopt.oliveyoung.R
import com.sopt.oliveyoung.databinding.ActivityMainBinding
import com.sopt.oliveyoung.util.binding.BindingActivity
import replace
import timber.log.Timber

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
        changeFragment(R.id.menu_home)
    }

    private fun addListeners() {
        binding.bnvMain.setOnItemSelectedListener {
            changeFragment(it.itemId)
            true
        }
    }

    private fun changeFragment(menuItemId: Int) = when (menuItemId) {
        R.id.menu_home -> replace<HomeFragment>(R.id.fcv_main)
        R.id.menu_like -> replace<LikeFragment>(R.id.fcv_main)
        R.id.menu_my -> replace<MyFragment>(R.id.fcv_main)
        R.id.menu_hamburger_menu -> replace<MenuFragment>(R.id.fcv_main)
        else -> Timber.e(IllegalArgumentException("Not found menu item id"))
    }
}