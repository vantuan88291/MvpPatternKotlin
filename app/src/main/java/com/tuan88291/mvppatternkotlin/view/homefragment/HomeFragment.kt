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
import com.tuan88291.mvppatternkotlin.data.DataMain
import com.tuan88291.mvppatternkotlin.data.entity.DataRoom
import com.tuan88291.mvppatternkotlin.data.room.livedata.MyViewModel
import com.tuan88291.mvppatternkotlin.databinding.HomeFragmentBinding
import com.tuan88291.mvppatternkotlin.utils.SharedPrefs

class HomeFragment : BaseFragment(), HomeContract {
    private val db: MyViewModel by lazy{ ViewModelProviders.of(this).get(MyViewModel::class.java) }
    private var binding: HomeFragmentBinding? = null
    private val presenter: HomePresenter by lazy { HomePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding!!.getRoot()
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycle.addObserver(presenter)
        binding!!.button.setOnClickListener({ view1 -> db.insert(DataRoom("test", 1)) })

        db.allData.observe(this, Observer<List<DataRoom>> { this.onDataChange(it) })

    }

    override fun onLoading() {

    }

    override fun onLoadComplete() {

    }

    override fun onError(mess: String) {

//        Toast.makeText(App.applicationContext(), "" + SharedPrefs.instance?.get("keyObj", DataMain::class.java), Toast.LENGTH_SHORT).show()

    }


    override fun onDataChange(data: List<DataRoom>) {
        LogUtils.a(data.size)
        binding?.button?.setText(data.size.toString() + "")
        mContext()!!.setItem(data.size.toString() + "")
//        val item = DataMain("test2", 1)
//        SharedPrefs.instance?.put("keyObj", item)

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(presenter)
    }
}
