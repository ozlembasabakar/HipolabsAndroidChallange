package com.example.hipolabschallange

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hipolabschallange.data.DataSource
import com.example.hipolabschallange.data.Repository
import com.example.hipolabschallange.model.Hipo
import com.example.hipolabschallange.model.Member
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _members = MutableStateFlow(MembersScreenViewState())
    val members: StateFlow<MembersScreenViewState> = _members.asStateFlow()

    /*= searchText
    .combine(_members) { text, members ->
        if (text.isBlank()) {
            members
        } else {
            members.member.filter {
                it.doesNameMatched(text)
            }
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        _members.value
    )*/

    val isError = mutableStateOf(false)
    val isDialogVisible = mutableStateOf(false)


    fun onSearchBarTextChanged(name: String) {
        _searchText.value = name
        Log.d("ozlem", "name: $name, _searchText: ${_searchText.value}")
    }

    fun addNewMember(
        name: String,
        position: String,
    ) {
        val member = Member(
            age = null,
            github = null,
            hipo = Hipo(position, years_in_hipo = null),
            location = null,
            name = name
        )
        val newMemberList = repository.addNewMemberAndGetAllMembers(member)

        _members.update {
            it.copy(
                member = newMemberList
            )
        }
    }
}

data class MembersScreenViewState(
    val member: List<Member> = DataSource().members,
)