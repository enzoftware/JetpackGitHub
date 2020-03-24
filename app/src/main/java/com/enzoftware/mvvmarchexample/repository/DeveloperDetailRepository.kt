package com.enzoftware.mvvmarchexample.repository

import com.enzoftware.mvvmarchexample.api.DeveloperApi
import com.enzoftware.mvvmarchexample.model.Developer
import com.enzoftware.mvvmarchexample.model.Repository
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 3/23/20.
 * Contact: lizama.enzo@gmail.com
 */

class DeveloperDetailRepository @Inject constructor(
    private val developerApi: DeveloperApi
){
    suspend fun getDeveloper(name:String): Developer{
        return developerApi.getDeveloper(name)
    }

    suspend fun getRepositories(owner: String): List<Repository>{
        return developerApi.getRepos(owner)
    }
}