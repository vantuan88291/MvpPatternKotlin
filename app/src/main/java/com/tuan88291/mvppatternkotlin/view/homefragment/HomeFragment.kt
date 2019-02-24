package com.tuan88291.mvppatternkotlin.view.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.blankj.utilcode.util.LogUtils
import com.tuan88291.mvppatternkotlin.BaseFragment
import com.tuan88291.mvppatternkotlin.R
import com.tuan88291.mvppatternkotlin.data.entity.DataRoom
import com.tuan88291.mvppatternkotlin.data.room.livedata.MyViewModel
import com.tuan88291.mvppatternkotlin.databinding.HomeFragmentBinding

class HomeFragment : BaseFragment(), HomeContract {
    private var db: MyViewModel? = null
    private var binding: HomeFragmentBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = ViewModelProviders.of(this).get(MyViewModel::class.java)
    }

    override fun setView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding!!.getRoot()
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {

        lifecycle.addObserver(HomePresenter.instance.setCallBack(this))
        binding!!.button.setOnClickListener({ view1 -> db!!.insert(DataRoom("test", 1)) })

        db!!.allData.observe(this, Observer<List<DataRoom>> { this.onDataChange(it) })

    }

    override fun onLoading() {

    }

    override fun onLoadComplete() {

    }

    override fun onError(mess: String) {

        Toast.makeText(mContext(), mess, Toast.LENGTH_SHORT).show()
    }


    override fun onDataChange(data: List<DataRoom>) {
        LogUtils.a(data.size)
        binding!!.button.setText(data.size.toString() + "")
        mContext()!!.setItem(data.size.toString() + "")

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(HomePresenter.instance.setCallBack(this))
    }
}
