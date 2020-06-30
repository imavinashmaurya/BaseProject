package com.baseproject.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    protected fun hideStatusBarAndActionBar() {
        val decorView: View = window.decorView
        // Hide the status bar.
        val uiOptions: Int = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()
    }

    protected fun showActivity(cls: Class<*>, finish: Boolean = false) {
        val intent = Intent(this, cls)
        startActivity(intent)
        if (finish) finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun setToolbar(title: String? = null) {
/*        toolbarSmall?.let {
            setSupportActionBar(toolbarSmall)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
            supportActionBar?.title = title
        }*/
    }


}
