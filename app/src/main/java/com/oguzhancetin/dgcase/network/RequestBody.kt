package com.oguzhancetin.dgcase.network

import com.google.gson.annotations.SerializedName

class RequestBody(
    @SerializedName("GUID")
    val GUID: String
)

class HashResponse(
    @SerializedName("hash")
    val hash: String
)
