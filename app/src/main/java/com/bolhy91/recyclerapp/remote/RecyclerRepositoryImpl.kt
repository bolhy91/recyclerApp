package com.bolhy91.recyclerapp.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthCredential
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecyclerRepositoryImpl @Inject constructor(
    private val recyclerApi: RecyclerApi
) {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun getNotices(): Flow<Resource<List<NoticeListDto>>> {
        return flow {
            emit(Resource.Loading(true))
            val remoteProducts = try {
                val results = recyclerApi.getNotices()
                results
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("couldn't load data ${e.message}"))
                null
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("couldn't load data http: ${e.message}"))
                null
            }
            remoteProducts?.let { results ->
                emit(Resource.Success(data = results))
                emit(Resource.Loading(false))
            }
        }
    }
}