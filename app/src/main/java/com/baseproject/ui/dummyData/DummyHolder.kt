package com.baseproject.ui.dummyData

import android.content.Context
import android.view.View
import com.baseproject.model.dummyData.DummyDataResponse
import com.kalpesh.krecyclerviewadapter.KRecyclerViewHolder
import kotlinx.android.synthetic.main.row_dummy_data.view.*


class DummyHolder(itemView: View): KRecyclerViewHolder(itemView) {
    override fun setData(context: Context, itemObject: Any) {
        super.setData(context, itemObject)
        if (itemObject is DummyDataResponse) {
            itemView.tvDummyData?.text = itemObject.name
        }
    }

}