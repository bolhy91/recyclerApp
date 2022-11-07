package com.bolhy91.recyclerapp.remote

import retrofit2.http.GET

interface RecyclerApi {
    @GET("notices")
    suspend fun getNotices(): List<NoticeListDto>

    @GET("places")
    suspend fun getPlaces(): List<PlaceListDto>
}