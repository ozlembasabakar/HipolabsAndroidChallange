package com.example.hipolabschallange.model

@kotlinx.serialization.Serializable
data class Member(
    val age: Int?,
    val github: String?,
    val hipo: Hipo?,
    val location: String?,
    val name: String?,
) {
    fun doesNameMatched(text: String): Boolean {
        return name?.contains(text, ignoreCase = true) ?: false
    }
}