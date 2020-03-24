package com.enzoftware.mvvmarchexample.repository

import com.enzoftware.mvvmarchexample.api.SearchApi
import com.enzoftware.mvvmarchexample.model.SimpleDeveloper
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 3/23/20.
 * Contact: lizama.enzo@gmail.com
 */
class SearchDevelopersRepository @Inject constructor(
    private val searchApi: SearchApi
) {
    suspend fun searchDevelopers(query: String): List<SimpleDeveloper> {
        return searchApi.searchDevelopers(query)
    }
}