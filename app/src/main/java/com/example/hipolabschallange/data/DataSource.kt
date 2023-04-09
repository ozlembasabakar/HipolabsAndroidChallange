package com.example.hipolabschallange.data

import com.example.hipolabschallange.model.Hipo
import com.example.hipolabschallange.model.Member

class DataSource {
    val members = mutableListOf(
        Member(
            name = "Yasin Cetiner",
            age = 33,
            location = "Istanbul",
            github = "artizco",
            hipo = Hipo(
                position = "Android Team Lead",
                years_in_hipo = 5
            )
        ),
        Member(
            name = "Mithat Sinan Sari",
            age = 29,
            location = "Istanbul",
            github = "mitsinsar",
            hipo = Hipo(
                position = "Android Developer",
                years_in_hipo = 4
            )
        ),
        Member(
            name = "Miraç Özkan",
            age = 25,
            location = "Istanbul",
            github = "miracozkan",
            hipo = Hipo(
                position = "Android Developer",
                years_in_hipo = 3
            )
        ),
        Member(
            name = "Onuralp Avcı",
            age = 23,
            location = "Ankara",
            github = "onuralpavci",
            hipo = Hipo(
                position = "Android Developer",
                years_in_hipo = 2
            )
        ),
    )
}