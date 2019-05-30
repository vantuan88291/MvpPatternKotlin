package com.tuan88291.mvppatternkotlin.view.fragment.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.blankj.utilcode.util.LogUtils
import com.tuan88291.mvppatternkotlin.BaseFragment
import com.tuan88291.mvppatternkotlin.R
import com.tuan88291.mvppatternkotlin.data.local.entity.DataRoom
import com.tuan88291.mvppatternkotlin.data.local.room.livedata.MyViewModel
import com.tuan88291.mvppatternkotlin.databinding.HomeFragmentBinding
import com.tuan88291.mvppatternkotlin.utils.observe.AutoDisposable
import com.tuan88291.mvppatternkotlin.utils.observe.ObserveEasy

class HomeFragment : BaseFragment(), HomeContract {
    private val db: MyViewModel by lazy{ ViewModelProviders.of(this).get(MyViewModel::class.java) }
    private var binding: HomeFragmentBinding? = null
    private val presenter: HomePresenter by lazy { HomePresenter(this) }
    private val autodis = AutoDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autodis.bindTo(this.lifecycle)
    }

    override fun setView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding!!.getRoot()
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
//        lifecycle.addObserver(presenter)
        binding!!.button.setOnClickListener({ view1 -> db.insert(DataRoom("test", 1)) })

        db.allData.observe(this, Observer<List<DataRoom>> { this.onDataChange(it) })

        object : ObserveEasy(){
            override fun getDispose(): AutoDisposable? {
                return autodis
            }

            override fun doBackground(): Any? {

                return null
            }

            override fun onFail(err: String) {
                super.onFail(err)
            }

            override fun onLoadComplete() {
                super.onLoadComplete()
            }

            override fun onLoading() {
                super.onLoading()
            }

            override fun onSuccess(result: Any?) {
                super.onSuccess(result)
            }

        }
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
//        lifecycle.removeObserver(presenter)
    }
}
