package com.ominext.moviedb.base

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.ominext.moviedb.common.DebugLog
import com.ominext.moviedb.common.dialog.AlertNotice
import com.ominext.moviedb.databinding.ActivityBaseBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected lateinit var baseBinding: ActivityBaseBinding

    @get:LayoutRes
    protected abstract val layoutResId: Int

    private var isErrorDialogShowing = false
    private val debugLog by lazy {
        DebugLog()
    }

    /**
     * Override onCreate function of Activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBaseBinding()
        setupViews()
        initData()
        observeData()
    }

    private fun initBaseBinding() {
        baseBinding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(baseBinding.root)
        View.inflate(this, layoutResId, baseBinding.activityContent)
        binding = inflateBinding(baseBinding.activityContent)
    }

    abstract fun inflateBinding(viewGroup: ViewGroup): VB

    open fun setupViews() {}
    abstract fun initData()
    abstract fun observeData()

    /**
     * This function is used to show loading or not
     * @param isLoading is [Boolean] value
     */
    fun showLoading(isLoading: Boolean) {
        if (isLoading && baseBinding.activityError.isVisible) {
            baseBinding.activityError.isVisible = false
        }
        baseBinding.activityLoading.isVisible = isLoading
    }

    /**
     * This is the method to show error dialog
     */
    fun showErrorDialog(message: String, name: String? = null) {
        if (isErrorDialogShowing) {
            debugLog.d("skip show if showing $name")
            return
        }

        AlertNotice.show(this, message) {
            isErrorDialogShowing = false
        }
        isErrorDialogShowing = true
    }
}
