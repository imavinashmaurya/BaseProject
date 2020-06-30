package com.baseproject.ui.dummyData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.baseproject.R
import com.baseproject.api.APIConstants
import com.baseproject.api.Repository
import com.baseproject.model.APIResponse
import com.baseproject.model.dummyData.DummyDataRequest
import com.baseproject.model.dummyData.DummyDataResponse
import com.baseproject.ui.BaseActivity
import com.baseproject.utils.CustomAlertDialog
import com.kalpesh.krecyclerviewadapter.KRecyclerViewAdapter
import com.kalpesh.krecyclerviewadapter.KRecyclerViewHolder
import com.kalpesh.krecyclerviewadapter.KRecyclerViewHolderCallBack
import com.kalpesh.krecyclerviewadapter.KRecyclerViewItemClickListener
import kotlinx.android.synthetic.main.activity_dummy.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class DummyActivity : BaseActivity(), View.OnClickListener {

    var dummyDataList: ArrayList<DummyDataResponse> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)
        setupUI()
        setupStaticData()
        setupDummyRecyclerView()
    }

    private fun setupUI() {
        // add click listener
        btDummy?.setOnClickListener(this)
    }

    private fun setupStaticData() {
        dummyDataList.add(DummyDataResponse(1, "Avinash", ""))
        dummyDataList.add(DummyDataResponse(1, "Android", ""))
        dummyDataList.add(DummyDataResponse(1, "IOS", ""))
    }

    private fun setupDummyRecyclerView() {
        val adapter =
            KRecyclerViewAdapter(
                this@DummyActivity,
                dummyDataList,
                object : KRecyclerViewHolderCallBack {
                    override fun onCreateViewHolder(viewGroup: ViewGroup): KRecyclerViewHolder {
                        val view =
                            LayoutInflater.from(this@DummyActivity)
                                .inflate(R.layout.row_dummy_data, viewGroup, false)
                        return DummyHolder(view)
                    }

                    override fun onHolderDisplayed(p0: KRecyclerViewHolder, p1: Int) {
                    }

                },
                KRecyclerViewItemClickListener { _, itemObject, _ ->
                    if (itemObject is DummyDataResponse) {
                        // handle click
                    }
                })

        val layoutManager =
            LinearLayoutManager(this@DummyActivity, LinearLayoutManager.VERTICAL, false)
        rvDummy?.adapter = adapter
        rvDummy?.layoutManager = layoutManager
        rvDummy?.addItemDecoration(
            DividerItemDecoration(
                this@DummyActivity,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun dummyApiCall() {
        Repository.getDataDummyCall(DummyDataRequest(1, "dummyData"), object :
            Callback<APIResponse<DummyDataResponse>> {
            override fun onFailure(call: Call<APIResponse<DummyDataResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<APIResponse<DummyDataResponse>>,
                response: Response<APIResponse<DummyDataResponse>>
            ) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btDummy -> {
                // do some work
                val message = "Package: $packageName \n Url: ${APIConstants.apiPath}"
                CustomAlertDialog(this@DummyActivity, message).show()
            }
        }
    }

}