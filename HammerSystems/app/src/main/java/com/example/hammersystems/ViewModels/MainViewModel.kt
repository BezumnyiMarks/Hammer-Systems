package com.example.hammersystems.ViewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammersystems.Data.Meals
import com.example.hammersystems.Repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val meals = MutableStateFlow(Meals(listOf()))
    val mealsLoading = MutableStateFlow(false)
    val mealsError = MutableStateFlow(false)
    val category = MutableStateFlow("")
    val tabPosition = MutableStateFlow(-1)

    fun loadMeals(letter: String){
        mealsLoading.value = true
        mealsError.value = false
        viewModelScope.launch {
            kotlin.runCatching {
                Repository.RetrofitInstance.searchMeals.getMeals(letter)
            }.fold(
                onSuccess = {
                    it.meals.forEach {
                        it.strCategory = letter
                    }
                    meals.value = it
                    mealsLoading.value = false
                    mealsError.value = false
                },
                onFailure = {
                    Log.d("LoadCharacterDetails", it.message ?:"")
                    mealsLoading.value = false
                    mealsError.value = true
                }
            )
        }
    }
}