package com.example.hipolabschallange

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hipolabschallange.model.Hipo
import com.example.hipolabschallange.model.Member
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(

) : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _members = MutableStateFlow(memberList)
    val members = searchText
        .combine(_members) { text, members ->
            if (text.isBlank()) {
                members
            } else {
                members.filter {
                    it.doesNameMatched(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            _members.value
        )

    fun onSearchBarTextChanged(name: String) {
        _searchText.value = name
        Log.d("ozlem", "name: $name, _searchText: ${_searchText.value}")
    }
}

val memberList = listOf(
    Member(
        name = "Özlem",
        hipo = Hipo(position = null, years_in_hipo = null),
        age = null,
        github = null,
        location = null
    ),
    Member(
        name = "Osman",
        hipo = Hipo(position = null, years_in_hipo = null),
        age = null,
        github = null,
        location = null
    ),
    Member(
        name = "Özgün",
        hipo = Hipo(position = null, years_in_hipo = null),
        age = null,
        github = null,
        location = null
    ),
    Member(
        name = "Nastia",
        hipo = Hipo(position = null, years_in_hipo = null),
        age = null,
        github = null,
        location = null
    ),
    Member(
        name = "Ayşe",
        hipo = Hipo(position = null, years_in_hipo = null),
        age = null,
        github = null,
        location = null
    ),
    Member(
        name = "Buse",
        hipo = Hipo(position = null, years_in_hipo = null),
        age = null,
        github = null,
        location = null
    ),
)