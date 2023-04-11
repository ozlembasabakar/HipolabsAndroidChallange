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

        val matchedNameList = listOf(
            name,
            name?.replace(" ", ""),
            name?.lowercase(),
            name?.uppercase(),
            name?.replace(" ","")?.lowercase()
        )

        return matchedNameList.any {
            it?.contains(text, ignoreCase = true) ?: false
        }
    }
}