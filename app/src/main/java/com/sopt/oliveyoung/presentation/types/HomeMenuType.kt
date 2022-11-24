package com.sopt.oliveyoung.presentation.types

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.oliveyoung.R

enum class HomeMenuType(@DrawableRes val imgRes: Int, @StringRes val strRes: Int) {
    CATEGORY(
        R.drawable.img_catgory,
        R.string.home_menu_category
    ),
    SKIN_CARE(R.drawable.img_product_sample, R.string.home_menu_skincare),
    BODY_CARE(R.drawable.img_bodycare, R.string.home_menu_bodycare),
    HAIR_CARE(R.drawable.img_haircare, R.string.home_menu_haircare),
    MAKEUP(R.drawable.img_makeup, R.string.home_menu_makeup),
    PERFUME_AND_DIFFUSER(
        R.drawable.img_perfume_and_diffuser,
        R.string.home_menu_perfume_and_diffuser
    ),
    BEAUTY_ITEM(R.drawable.img_beauty_item, R.string.home_menu_beauty_item),
    HEALTH_ITEM(R.drawable.img_health_item, R.string.home_menu_health_item),
    FOOD(R.drawable.img_food, R.string.home_menu_food),
    LIFE_AND_HOME(R.drawable.img_life_and_home, R.string.home_menu_life_and_home)
}