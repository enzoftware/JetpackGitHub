package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.model.Developer
import com.enzoftware.mvvmarchexample.model.Repository


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */

interface DeveloperApi {
    suspend fun getDeveloper(name: String): Developer
    suspend fun getRepos(owner: String): List<Repository>
}