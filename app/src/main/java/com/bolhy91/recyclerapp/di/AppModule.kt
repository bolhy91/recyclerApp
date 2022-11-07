package com.bolhy91.recyclerapp.di

import com.bolhy91.recyclerapp.remote.RecyclerApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://localhost:3000/api/v1/").build()
    }

    @Provides
    @Singleton
    fun provideRecyclerApi(retrofit: Retrofit): RecyclerApi =
        retrofit.create(RecyclerApi::class.java)
}