package com.baseproject.api

object APICalling {
    fun apiCall(): APIServices {
        return RetrofitClient.getClient(APIConstants.apiPath)!!
            .create<APIServices>(APIServices::class.java)
    }
}