package com.enzoftware.mvvmarchexample.repository

import com.enzoftware.mvvmarchexample.api.SearchApi
import com.enzoftware.mvvmarchexample.model.Language
import com.enzoftware.mvvmarchexample.model.Repository
import java.time.LocalDateTime
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 3/23/20.
 * Contact: lizama.enzo@gmail.com
 */
class FeedRepository @Inject constructor(
    private val searchApi: SearchApi
){
    suspend fun getTrendingRepositories(language: Language): List<Repository>{
        return searchApi.getHotRepos(language, LocalDateTime.now().minusMonths(1))
    }
}