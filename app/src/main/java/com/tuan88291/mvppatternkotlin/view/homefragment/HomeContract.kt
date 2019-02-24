package com.tuan88291.mvppatternkotlin.view.homefragment

import com.tuan88291.mvppatternkotlin.BaseContract
import com.tuan88291.mvppatternkotlin.data.entity.DataRoom


interface HomeContract : BaseContract {
    fun onDataChange(data: List<DataRoom>)
    interface HomePresenterView {
        fun getApi()
    }
}
