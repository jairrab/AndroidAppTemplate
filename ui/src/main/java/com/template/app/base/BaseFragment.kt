package com.template.app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber

abstract class BaseFragment(resId: Int) : Fragment(resId){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.v("${javaClass.simpleName} | onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.v("${javaClass.simpleName} | onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.v("${javaClass.simpleName} | onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.v("${javaClass.simpleName} | onDestroy")
    }
}