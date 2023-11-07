package com.example.hammersystems.Data

import androidx.compose.ui.graphics.Color

data class BottomNavItem(
    val title: String,
    val selectedColor: Color,
    val unselectedColor: Color,
    val icon: Int
)
