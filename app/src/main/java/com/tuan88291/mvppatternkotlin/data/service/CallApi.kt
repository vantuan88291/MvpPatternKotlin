package com.tuan88291.mvppatternkotlin.data.service


import com.tuan88291.mvppatternkotlin.data.model.CommonData
import com.tuan88291.mvppatternkotlin.data.model.Data
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface CallApi {
    @get:GET("api")
    val list: Call<CommonData<*>>
    @get:FormUrlEncoded
    @get:POST("api")
    val listMore: Call<CommonData<Data>>
}
