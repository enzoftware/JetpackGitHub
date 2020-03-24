package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.api.response.RepositoryResponse
import com.enzoftware.mvvmarchexample.model.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Enzo Lizama Paredes on 3/14/20.
 * Contact: lizama.enzo@gmail.com
 */
class RepoApiClient(retrofit: Retrofit) : RepoApi {

    interface Service {
        @GET("repos/{owner}/{repo}")
        suspend fun getRepository(
            @Path("owner") owner: String,
            @Path("repo") repo: String
        ): RepositoryResponse

    }

    private val service = retrofit.create(Service::class.java)

    override suspend fun getRepo(owner: String, repo: String): Repository {
        return withContext(IO) {
            service.getRepository(owner, repo).toModel()
        }
    }
}