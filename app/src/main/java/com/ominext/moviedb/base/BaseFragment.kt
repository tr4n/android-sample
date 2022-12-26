package com.ominext.moviedb.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.ominext.moviedb.common.DebugLog

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    protected abstract val viewModel: VM

    val debugLog by lazy { DebugLog() }

    /**
     * Override onCreateView function of Fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(layoutInflater, container, false)
        return binding.root
    }

    /**
     * Override onViewCreated function of Fragment
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        initData()
        observeBase()
        debugLog.i(this::class.java.simpleName)
    }

    /**
     * Override onDestroyView function of Fragment
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    protected open fun setupViews() {
        // Implement in overing function
    }

    protected open fun initData() {
        // Implement in overing function
    }

    private fun observeBase() {
        viewModel.mLoading.observe(viewLifecycleOwner) { shouldLoading ->
            (activity as? BaseActivity<*>)?.showLoading(shouldLoading)
        }
        viewModel.mError.observe(viewLifecycleOwner) { throwable ->
            val message = throwable?.message
            val activity = activity as? BaseActivity<*>
            if (activity != null && message != null) {
                activity.showErrorDialog(message)
            }
        }
    }

    protected open fun observeData() {
        // Implement in overing function
    }
}