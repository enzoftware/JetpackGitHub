package com.enzoftware.mvvmarchexample.repository

import com.enzoftware.mvvmarchexample.api.SearchApi
import com.enzoftware.mvvmarchexample.model.GithubRepository
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 3/23/20.
 * Contact: lizama.enzo@gmail.com
 */
class SearchRepositoriesRepository @Inject constructor(
    private val searchApi: SearchApi
) {

    suspend fun searchRepositories(query: String): List<GithubRepository> {
        return searchApi.searchRepos(query)
    }
}