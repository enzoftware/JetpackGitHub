package com.enzoftware.mvvmarchexample.repository

import com.enzoftware.mvvmarchexample.api.GithubRepositoryApi
import com.enzoftware.mvvmarchexample.database.RepoDatabase
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 3/23/20.
 * Contact: lizama.enzo@gmail.com
 */
class UserRepository @Inject constructor(
    private val repoDatabase: RepoDatabase,
    private val githubRepositoryApi: GithubRepositoryApi
) {

}