package com.example.data.remote.dto

import com.example.domain.model.DomainData
import com.example.domain.model.DomainResult

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

fun Data.toDomainData():DomainData = DomainData(results = results)

//fun Data.toDomainData(): DomainData {
//    return DomainData(
//        info = info,
//
//    )
//}

//fun Result.toDomainResult(): DomainResult = DomainResult(
//    created, gender, id, image, name, species, status, type
//)
//fun Data.toDomainData():DomainData = DomainData(
//    count = info.count,
//    next = info.next,
//    pages = info.pages,
//    prev = info.prev,
//    created = ,
//    gender = ,
//    id = ,
//    image = ,
//    name =,
//    species = ,
//    status = ,
//    type =
//)