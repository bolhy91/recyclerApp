package com.bolhy91.recyclerapp.remote

data class NoticeListDto(
    val id: String,
    val name: String,
    val description: String,
    val banner: String,
    val schedule: String,
    val status: Boolean,
    val createdAt: String,
    val updatedAt: String
)
