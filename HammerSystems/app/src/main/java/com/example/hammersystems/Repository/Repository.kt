package com.example.hammersystems.Repository

import com.example.hammersystems.Data.Meals
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

class Repository{
     object RetrofitInstance{
          private val retrofit = Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(MoshiConverterFactory.create())
               .build()

          val searchMeals = retrofit.create(SearchMeals::class.java)
     }
}

interface SearchMeals{
     @GET("search.php")
     suspend fun getMeals(@Query("f") letter: String): Meals
}