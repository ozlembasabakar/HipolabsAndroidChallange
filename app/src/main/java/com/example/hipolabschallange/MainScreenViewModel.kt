package com.example.hipolabschallange

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(

) : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _persons = MutableStateFlow(members)
    val persons = searchText
        .combine(_persons) { text, persons ->
            if(text.isBlank()) {
                persons
            } else {
                persons.filter {
                    it.doesNameMatch(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            _persons.value
        )

    fun onSearchBarTextChanged(name: String) {
        _searchText.value = name
        Log.d("ozlem", "name: $name, _searchText: ${_searchText.value}")
    }
}

data class Person(
    val name: String
) {
    fun doesNameMatch(text: String): Boolean {

        val matchingCombinations = listOf(
            name,
        )

        return matchingCombinations.any {
            it.contains(text, ignoreCase = true)
        }
    }
}

val members = listOf(
    Person(name = "Özlem"),
    Person(name = "Osman"),
    Person(name = "Özgün"),
    Person(name = "Nastia"),
    Person(name = "Ayşe"),
    Person(name = "Buse"),
)