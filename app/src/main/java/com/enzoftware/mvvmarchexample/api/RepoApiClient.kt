package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.model.Repository


/**
 * Created by Enzo Lizama Paredes on 3/14/20.
 * Contact: lizama.enzo@gmail.com
 */
class RepoApiClient : RepoApi {
    override suspend fun getRepo(owner: String, repo: String): Repository {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}