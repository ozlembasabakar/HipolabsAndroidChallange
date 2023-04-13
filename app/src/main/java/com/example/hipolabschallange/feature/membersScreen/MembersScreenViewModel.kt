package com.example.hipolabschallange.feature.membersScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hipolabschallange.data.Repository
import com.example.hipolabschallange.model.Hipo
import com.example.hipolabschallange.model.Member
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MembersScreenViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    val name = mutableStateOf("")
    val position = mutableStateOf("")
    val yearsInHipo = mutableStateOf("")
    val age = mutableStateOf("")
    val github = mutableStateOf("")
    val location = mutableStateOf("")

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _members = MutableStateFlow(repository.getAllMember())
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

    val isError = mutableStateOf(false)
    val isDialogVisible = mutableStateOf(false)

    fun validateOfRecord(): Boolean {
        return name.value.isBlank() || position.value.isBlank() || yearsInHipo.value.isBlank() || age.value.isBlank() || github.value.isBlank() || location.value.isBlank()
    }

    fun onSearchBarTextChanged(name: String) {
        _searchText.value = name
    }

    fun addNewMember(
        name: String,
        position: String,
        years_in_hipo: String,
        age: String,
        github: String,
        location: String,

        ) {
        val member = Member(
            age = age.toInt(),
            github = github,
            hipo = Hipo(position, years_in_hipo = years_in_hipo.toInt()),
            location = location,
            name = name
        )

        val newMemberList: MutableList<Member> = repository.addNewMemberAndGetAllMembers(member)

        _members.update {
            newMemberList
        }
    }
}