package com.example.hammersystems.Data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meals(
    @Json(name = "meals")
    val meals: List<Meal>
)

@JsonClass(generateAdapter = true)
data class Meal(
    @Json(name = "idMeal")
    val idMeal: String? = null,

    @Json(name = "strMeal")
    val strMeal: String? = null,

    @Json(name = "strCategory")
    var strCategory: String? = null,

    @Json(name = "strMealThumb")
    val strMealThumb: String? = null,

    @Json(name = "strIngredient1")
    val strIngredient1: String? = null,

    @Json(name = "strIngredient2")
    val strIngredient2: String? = null,

    @Json(name = "strIngredient3")
    val strIngredient3: String? = null,

    @Json(name = "strIngredient4")
    val strIngredient4: String? = null,

    @Json(name = "strIngredient5")
    val strIngredient5: String? = null,

    @Json(name = "strIngredient6")
    val strIngredient6: String? = null,

    @Json(name = "strIngredient7")
    val strIngredient7: String? = null,

    @Json(name = "strIngredient8")
    val strIngredient8: String? = null,

    @Json(name = "strIngredient9")
    val strIngredient9: String? = null,

    @Json(name = "strIngredient10")
    val strIngredient10: String? = null,

    @Json(name = "strIngredient11")
    val strIngredient11: String? = null,

    @Json(name = "strIngredient12")
    val strIngredient12: String? = null,

    @Json(name = "strIngredient13")
    val strIngredient13: String? = null,

    @Json(name = "strIngredient14")
    val strIngredient14: String? = null,

    @Json(name = "strIngredient15")
    val strIngredient15: String? = null,

    @Json(name = "strIngredient16")
    val strIngredient16: String? = null,

    @Json(name = "strIngredient17")
    val strIngredient17: String? = null,

    @Json(name = "strIngredient18")
    val strIngredient18: String? = null,

    @Json(name = "strIngredient19")
    val strIngredient19: String? = null,

    @Json(name = "strIngredient20")
    val strIngredient20: String? = null
)