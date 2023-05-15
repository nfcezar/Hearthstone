package com.projects.core.api

import com.projects.core.service.HearthstoneApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HearthstoneInfoApiService {
    private const val URL = "https://api.hearthstonejson.com/v1/173781/"

    fun createInstance(): HearthstoneApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL)
            .build()
            .create(HearthstoneApi::class.java)
    }
}