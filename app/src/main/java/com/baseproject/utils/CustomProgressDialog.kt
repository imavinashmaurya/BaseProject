package com.baseproject.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.RelativeLayout
import com.baseproject.R
import kotlinx.android.synthetic.main.custom_progress_dailog.*

/**
 * Custom alert dialog
 */
class CustomProgressDialog(context: Context) : Dialog(context) {

    init {
        init()
    }

    private fun init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(R.layout.custom_progress_dailog)
        val window = this.window
        if (window != null) {
            window.setLayout(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }


    fun changeLoadingText(text: String): CustomProgressDialog {
        tvLoadingText?.text = text
        return this
    }


}