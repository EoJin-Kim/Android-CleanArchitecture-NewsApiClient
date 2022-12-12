package com.ej.android_cleanarchitecture_newsapiclient.data.api

import com.ej.android_cleanarchitecture_newsapiclient.BuildConfig
import com.ej.android_cleanarchitecture_newsapiclient.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPIService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        contry:String,
        @Query("page")
        page:Int,
        @Query("apiKey")
        apiKey:String = BuildConfig.API_KEY
    ): Response<APIResponse>
}