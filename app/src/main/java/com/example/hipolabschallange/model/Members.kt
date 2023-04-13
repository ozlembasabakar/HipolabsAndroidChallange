package com.example.hipolabschallange.model

import kotlinx.serialization.Serializable

@Serializable
data class Members(
    val company: String?,
    val members: List<Member?>?,
    val team: String?
)