package com.example.data.remote.dto

import com.example.domain.model.DomainData

/**
 * 2023-01-26
 * pureum
 */
data class Data(
    val info: Info,
    val results: List<Result>
)
data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)
data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
data class Location(
    val name: String,
    val url: String
)
data class Origin(
    val name: String,
    val url: String
)
fun Data.toDomainData(): List<DomainData> =
    results.map { DomainData(it.name,it.status,it.species,it.image) }
//    DomainData(
//       // next = info.next,
//        //prev = info.prev,
//        name = results.map { it.name },
//        status = results.map { it.status },
//        species = results.map { it.species },
//        image = results.map { it.image }
//    )