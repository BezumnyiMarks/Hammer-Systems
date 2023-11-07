package com.example.hammersystems.Data

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val AppBarCollapsedHeight = 56.dp
val AppBarExpendedHeight = 202.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)
var lettersListIndex = 0
val allMeals = mutableListOf<Meal>()