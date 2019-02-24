package com.tuan88291.mvppatternkotlin.data.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

import com.tuan88291.mvppatternkotlin.utils.Common.DOMAIN


object ServiceGenerator {
    private var httpClient: OkHttpClient.Builder? = null
    private val builder = Retrofit.Builder()
        .baseUrl(DOMAIN)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())

    // service have not token
    fun <S> createService(serviceClass: Class<S>): S {
        httpClient = OkHttpClient.Builder()
        httpClient!!.readTimeout(3, TimeUnit.MINUTES)
        httpClient!!.connectTimeout(3, TimeUnit.MINUTES)
        httpClient!!.addInterceptor { chain ->
            val original = chain.request()
            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Accept", "application/json")
                .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val client = httpClient!!.build()
        val retrofit = builder.client(client).addConverterFactory(GsonConverterFactory.create(gson)).build()
        return retrofit.create(serviceClass)
    }

    fun <S> createServiceToken(serviceClass: Class<S>): S {
        httpClient = OkHttpClient.Builder()
        httpClient!!.readTimeout(3, TimeUnit.MINUTES)
        httpClient!!.connectTimeout(3, TimeUnit.MINUTES)
        httpClient!!.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .method(original.method(), original.body()).build()
            chain.proceed(requestBuilder)
        }
        val client = httpClient!!.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }
}
