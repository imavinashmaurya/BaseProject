package com.baseproject.api

import com.baseproject.model.APIResponse
import com.baseproject.model.dummyData.DummyDataRequest
import com.baseproject.model.dummyData.DummyDataResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface APIServices {
    // post request with fields
    @FormUrlEncoded
    @POST("endpoint")
    fun dummyApiCall(@Field("loginUserId") loginUserId: Int): Call<APIResponse<JSONObject>>// <APIResponse<Pass Data type of data>>

    // post request with fields
    @POST("endpoint")
    fun dummyApiCall(@Body body: DummyDataRequest): Call<APIResponse<DummyDataResponse>>// <APIResponse<Pass Data type of data>>

}

