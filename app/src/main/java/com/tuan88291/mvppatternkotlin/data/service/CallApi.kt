package com.tuan88291.mvppatternkotlin.data.service


import com.tuan88291.mvppatternkotlin.data.model.CommonData
import com.tuan88291.mvppatternkotlin.data.model.Data
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
@JvmSuppressWildcards
interface CallApi {
    @GET("api")
    fun getList(): Call<CommonData<Data>>
    @FormUrlEncoded
    @POST("api")
    fun listMore(): Call<CommonData<Data>>
}
