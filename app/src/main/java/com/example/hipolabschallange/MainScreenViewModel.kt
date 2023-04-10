package com.example.hipolabschallange

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
class MainScreenViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

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


    fun onSearchBarTextChanged(name: String) {
        _searchText.value = name
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

        val newMemberList: MutableList<Member> = repository.addNewMemberAndGetAllMembers(member)

        _members.update {
            newMemberList
        }
    }
}

data class MembersScreenViewState(
    val member: List<Member>,
)