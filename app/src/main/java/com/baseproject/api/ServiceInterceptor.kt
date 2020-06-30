package com.baseproject.api

import com.baseproject.utils.LocalStorage
import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor : Interceptor {

    var token: String = ""

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        //or use Token Function
        token = LocalStorage.getToken()
        if (token.isNotEmpty()) {
            val finalToken = "Bearer $token"
            request = request.newBuilder()
                .addHeader("Authorization", finalToken)
                .build()
        }

        return chain.proceed(request)
    }

}