package com.tuan88291.mvppatternkotlin.view.fragment.homefragment

import com.tuan88291.mvppatternkotlin.BaseContract
import com.tuan88291.mvppatternkotlin.data.local.entity.DataRoom


interface HomeContract : BaseContract {
    fun onDataChange(data: List<DataRoom>)
    interface HomePresenterView {
        fun getApi()
    }
}
