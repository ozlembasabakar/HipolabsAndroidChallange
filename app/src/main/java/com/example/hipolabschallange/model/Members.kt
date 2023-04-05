package com.example.hipolabschallange.model

@kotlinx.serialization.Serializable
data class Members(
    val company: String?,
    val members: List<Member?>?,
    val team: String?
)