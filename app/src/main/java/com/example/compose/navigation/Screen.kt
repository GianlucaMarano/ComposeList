package com.example.compose.navigation

import androidx.annotation.StringRes
import com.example.compose.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object First : Screen("first", R.string.first)
    object Second : Screen("second", R.string.second)
}