package com.enzoftware.mvvmarchexample.api.response

import com.enzoftware.mvvmarchexample.util.DataResponse
import com.google.gson.annotations.SerializedName


/**
 * Created by Enzo Lizama Paredes on 3/14/20.
 * Contact: lizama.enzo@gmail.com
 */
class ListResponse<T : Any> {

    @SerializedName("total_count")
    var totalCount: Int? = null

    @SerializedName("incomplete_results")
    var incompleteResults: Boolean? = null

    @SerializedName("items")
    var items: List<T>? = null
}