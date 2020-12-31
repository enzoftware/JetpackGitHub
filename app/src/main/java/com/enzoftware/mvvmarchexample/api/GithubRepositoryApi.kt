package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.model.GithubRepository


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */

interface GithubRepositoryApi {
    suspend fun getRepo(owner: String, repo: String): GithubRepository
}