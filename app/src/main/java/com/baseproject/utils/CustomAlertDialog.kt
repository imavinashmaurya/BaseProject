package com.baseproject.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.baseproject.R
import kotlinx.android.synthetic.main.diaog_alert_custom.*

/**
 * Custom alert dialog
 */
class CustomAlertDialog(context: Context) : Dialog(context) {

    init {
        init()
    }

    /**
     * Call this method for dialog with title, des, and both positive and negative button
     */
    constructor(
        context: Context,
        title: String,
        desc: String,
        alertDialogButtonClicked: AlertDialogButtonClicked?
    ) : this(context) {
        setData(title, desc, alertDialogButtonClicked)
    }

    /**
     * Call this method with only one button and title
     */
    constructor(
        context: Context,
        title: String,
        alertDialogButtonClicked: AlertDialogButtonClicked?
    ) : this(context) {
        setData(title, "", alertDialogButtonClicked)
        btPositive2?.visibility = View.VISIBLE
        btPositive2?.text = "OK"
        clButtons?.visibility = View.GONE
    }

    /**
     * Call this method when want to display only text with single button without listening for button click event
     */
    constructor(
        context: Context,
        title: String
    ) : this(context) {
        setData(title, "", null)
        btPositive2?.visibility = View.VISIBLE
        btPositive2?.text = "OK"
        clButtons?.visibility = View.GONE
    }


    private fun init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(R.layout.diaog_alert_custom)
        val window = this.window
        if (window != null) {
            window.setLayout(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    private fun setData(
        title: String,
        desc: String,
        alertDialogButtonClicked: AlertDialogButtonClicked?
    ) {
        tvTitle?.text = title
        tvDes?.text = desc
        if (title.isEmpty()) {
            tvTitle?.visibility = View.GONE
        }
        if (desc.isEmpty()) {
            tvDes?.visibility = View.GONE
        }

        btNegative.setOnClickListener(View.OnClickListener {
            dismiss()
            alertDialogButtonClicked?.buttonClicked(false)
        })
        btPositive.setOnClickListener(View.OnClickListener {
            dismiss()
            alertDialogButtonClicked?.buttonClicked(true)
        })
        btPositive2.setOnClickListener(View.OnClickListener {
            dismiss()
            alertDialogButtonClicked?.buttonClicked(true)
        })
    }

    fun changeButtonName(positiveButton: String, negativeButton: String): CustomAlertDialog {
        btPositive?.text = positiveButton
        btNegative?.text = negativeButton
        return this
    }

    fun changeButtonColor(positiveColor: Int, negativeColor: Int): CustomAlertDialog {
        btPositive?.setTextColor(ContextCompat.getColor(context, positiveColor))
        btPositive2?.setTextColor(ContextCompat.getColor(context, positiveColor))
        btNegative?.setTextColor(ContextCompat.getColor(context, negativeColor))
        return this
    }

    fun changeButtonColor(positiveColor: Int): CustomAlertDialog {
        btPositive?.setTextColor(ContextCompat.getColor(context, positiveColor))
        btPositive2?.setTextColor(ContextCompat.getColor(context, positiveColor))
        return this
    }

    interface AlertDialogButtonClicked {
        fun buttonClicked(positive: Boolean)
    }

}