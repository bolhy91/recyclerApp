package com.bolhy91.recyclerapp.remote

data class PlaceListDto(
    val id: String,
    val name: String,
    val description: String,
    val latitude: String,
    val longitude: String,
    val schedule: String,
    val status: Boolean,
    val createdAt: String,
    val updatedAt: String
)
