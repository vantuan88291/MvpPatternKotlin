package com.tuan88291.mvppatternkotlin.view.homefragment

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.tuan88291.mvppatternkotlin.data.model.CommonData
import com.tuan88291.mvppatternkotlin.data.service.ApiUtil
import com.tuan88291.mvppatternkotlin.data.service.BaseInteractor
import com.tuan88291.mvppatternkotlin.data.service.CallApi
import com.tuan88291.mvppatternkotlin.data.service.customcallback.BaseRetrofit
import retrofit2.Response

class HomePresenter : BaseInteractor(), LifecycleObserver, HomeContract.HomePresenterView {

    private var v: HomeContract? = null
    fun setCallBack(v: HomeContract): HomePresenter {
        this.v = v
        return this
    }


    override fun callAPi(): CallApi {
        return ApiUtil.createApi()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun getApi() {

        object : BaseRetrofit<CommonData<*>>(callAPi().list, v!!) {
            override fun onGetApiComplete(response: Response<CommonData<*>>) {

            }

            override fun onFail(err: String) {
                v!!.onError(err)
            }

            override fun onLoading() {
                super.onLoading()
                v!!.onLoading()
            }

            override fun onLoadComplete() {
                super.onLoadComplete()
                v!!.onLoadComplete()
            }
        }
    }

    companion object {
        val instance = HomePresenter()
    }


}
