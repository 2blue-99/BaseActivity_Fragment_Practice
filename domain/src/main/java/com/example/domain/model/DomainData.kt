package com.example.domain.model

import android.icu.text.IDNA

/**
 * 2023-01-26
 * pureum
 */
data class DomainData(
    //val info: Info,
    val results: List<Any>
)

//data class Info(
//    val count: Int,
//    val next: String,
//    val pages: Int,
//    val prev: String
//)

data class DomainResult(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
//    val created: String,
//    val episode: List<String>,
//    val gender: String,
//    val id: Int,
//    val image: String,
//    val location: Location,
//    val name: String,
//    val origin: Origin,
//    val species: String,
//    val status: String,
//    val type: String,
//    val url: String
)

data class Location(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)
//    val count: Int,
//    val next: String,
//    val pages: Int,
//    val prev: String,
