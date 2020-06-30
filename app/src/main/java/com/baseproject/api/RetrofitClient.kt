package com.baseproject.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitClient {

    private var retrofit: Retrofit? = null
    private var gson = GsonBuilder()
        .setLenient()
        .create()

    fun getClient(baseUrl: String): Retrofit? {
        if (retrofit == null) {
            val client = OkHttpClient.Builder()
                .addInterceptor(ServiceInterceptor())
                //.readTimeout(45,TimeUnit.SECONDS)
                //.writeTimeout(45,TimeUnit.SECONDS)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit
    }
}