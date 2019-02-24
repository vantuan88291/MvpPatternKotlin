package com.tuan88291.mvppatternkotlin.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CommonData<T> {
    @SerializedName("data")
    @Expose
    var data: T? = null
    @SerializedName("status_code")
    @Expose
    var code: Int = 0
    @SerializedName("message")
    @Expose
    lateinit var message: String
}
