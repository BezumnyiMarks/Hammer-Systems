package com.example.hammersystems.Data

import androidx.compose.ui.graphics.Color

data class TabItem(
    val title: String,
    val selectedColor: Color,
    val unselectedColor: Color,
    val selectedBackgroudColor: Color,
    val unselectedBackgroudColor: Color
)
