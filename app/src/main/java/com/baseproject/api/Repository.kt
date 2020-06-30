package com.baseproject.api


import com.baseproject.model.APIResponse
import com.baseproject.model.dummyData.DummyDataRequest
import com.baseproject.model.dummyData.DummyDataResponse
import org.json.JSONObject
import retrofit2.Callback

object Repository {

    fun getDataDummyCall(
        loginId: Int,
        callback: Callback<APIResponse<JSONObject>>
    ) {
        APICalling.apiCall().dummyApiCall(loginUserId = loginId).enqueue(callback)
    }

    fun getDataDummyCall(
        dummyDataRequest: DummyDataRequest,
        callback: Callback<APIResponse<DummyDataResponse>>
    ) {
        APICalling.apiCall().dummyApiCall(dummyDataRequest).enqueue(callback)
    }
}