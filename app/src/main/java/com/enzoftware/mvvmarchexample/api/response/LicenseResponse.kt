package com.enzoftware.mvvmarchexample.api.response

import com.enzoftware.mvvmarchexample.model.License
import com.enzoftware.mvvmarchexample.util.DataResponse
import com.google.gson.annotations.SerializedName


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */


class LicenseResponse : DataResponse<License>() {

    @SerializedName("key")
    var key: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("spdx_id")
    var spdxId: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("node_id")
    var nodeId: String? = null

    override fun toModel() = License(
        key = key ?: "",
        name = name ?: "",
        spdxId = spdxId ?: ""
    )
}