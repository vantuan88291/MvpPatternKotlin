package com.tuan88291.mvppatternkotlin.view.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.blankj.utilcode.util.LogUtils
import com.tuan88291.mvppatternkotlin.BaseFragment
import com.tuan88291.mvppatternkotlin.R
import com.tuan88291.mvppatternkotlin.databinding.AboutFragmentBinding

class About : BaseFragment(), AboutContract {
    private var binding: AboutFragmentBinding? = null
    override fun setView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.about_fragment, container, false)
        return binding!!.getRoot()
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {

        lifecycle.addObserver(AboutPresenter.instance.setCallback(this))
        binding!!.title.setText(mContext()!!.getItem())

    }

    override fun inCreate() {
        LogUtils.a("inCreate")
    }

    override fun inResume() {
        LogUtils.a("in inResume")


    }

    override fun indestroy() {
        LogUtils.a("in indestroy")

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(AboutPresenter.instance)
    }
}
