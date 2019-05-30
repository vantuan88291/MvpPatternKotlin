package com.tuan88291.mvppatternkotlin.view.fragment.homefragment

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.tuan88291.mvppatternkotlin.data.local.model.CommonData
import com.tuan88291.mvppatternkotlin.data.local.model.Data
import com.tuan88291.mvppatternkotlin.data.remote.ApiUtil
import com.tuan88291.mvppatternkotlin.data.remote.BaseInteractor
import com.tuan88291.mvppatternkotlin.data.remote.CallApi
import com.tuan88291.mvppatternkotlin.data.remote.customcallback.BaseRetrofit
import retrofit2.Response

class HomePresenter(val v: HomeContract) : BaseInteractor(), LifecycleObserver, HomeContract.HomePresenterView {

    override fun callAPi(): CallApi {
        return ApiUtil.createApi()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun getApi() {

        object : BaseRetrofit<CommonData<Data>>(callAPi().getList(), v) {
            override fun onGetApiComplete(response: Response<CommonData<Data>>) {

            }

            override fun onFail(err: String) {
                v.onError(err)
            }

            override fun onLoading() {
                super.onLoading()
                v.onLoading()
            }

            override fun onLoadComplete() {
                super.onLoadComplete()
                v.onLoadComplete()
            }
        }
    }


}
