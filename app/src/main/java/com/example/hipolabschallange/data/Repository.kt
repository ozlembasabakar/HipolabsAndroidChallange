package com.example.hipolabschallange.data

import com.example.hipolabschallange.model.Member
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataSource: DataSource,
) {

    fun getAllMember(): List<Member> {
        return DataSource().members
    }

    fun addNewMemberAndGetAllMembers(member: Member): MutableList<Member> {
        dataSource.members.add(member)
        return dataSource.members
    }
}