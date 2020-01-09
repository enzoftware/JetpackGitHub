package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.api.response.DeveloperResponse
import com.enzoftware.mvvmarchexample.api.response.RepositoryResponse
import com.enzoftware.mvvmarchexample.model.Developer
import com.enzoftware.mvvmarchexample.model.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */

class DeveloperApiClient(retrofit: Retrofit) : DeveloperApi {

    interface Service {
        @GET("users/{name}")
        suspend fun getDeveloper(@Path("name") name: String): DeveloperResponse

        @GET("users/{owner}/repos")
        suspend fun getRepos(@Path("owner") owner: String): List<RepositoryResponse>
    }


    private val service = retrofit.create(Service::class.java)


    override suspend fun getDeveloper(name: String): Developer {
        return withContext(IO) {
            service.getDeveloper(name).toModel()
        }
    }

    override suspend fun getRepos(owner: String): List<Repository> {
        return withContext(IO) {
            service.getRepos(owner).map { response -> response.toModel() }
        }
    }

}