package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.api.response.ListResponse
import com.enzoftware.mvvmarchexample.api.response.GithubRepositoryResponse
import com.enzoftware.mvvmarchexample.api.response.SimpleDeveloperResponse
import com.enzoftware.mvvmarchexample.model.Language
import com.enzoftware.mvvmarchexample.model.GithubRepository
import com.enzoftware.mvvmarchexample.model.SimpleDeveloper
import com.enzoftware.mvvmarchexample.util.DateFormats
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDateTime


/**
 * Created by Enzo Lizama Paredes on 3/14/20.
 * Contact: lizama.enzo@gmail.com
 */
class SearchApiClient(retrofit: Retrofit) : SearchApi {

    interface Service {
        @GET("search/repositories")
        suspend fun getHotRepositories(
            @Query("q") query: String,
            @Query("sort") sort: String = "stars"
        ): ListResponse<GithubRepositoryResponse>

        @GET("search/users")
        suspend fun getHotDevelopers(
            @Query("q") query: String,
            @Query("sort") sort: String = "stars"
        ): ListResponse<SimpleDeveloperResponse>

        @GET("search/repositories")
        suspend fun getRepositories(
            @Query("q") query: String
        ): ListResponse<GithubRepositoryResponse>

        @GET("search/users")
        suspend fun getDevelopers(
            @Query("q") query: String
        ): ListResponse<SimpleDeveloperResponse>

    }


    private val service = retrofit.create(Service::class.java)

    override suspend fun getHotRepos(language: Language, from: LocalDateTime): List<GithubRepository> {
        return withContext(IO) {
            service.getHotRepositories(
                    "language:${language.title} created:>${from.format(DateFormats.ofSearchQuery())}"
                )
                .items
                ?.map { response -> response.toModel() } ?: emptyList()
        }

    }

    override suspend fun getHotDevelopers(
        language: Language,
        from: LocalDateTime
    ): List<SimpleDeveloper> {
        return withContext(IO) {
            service.getHotDevelopers(
                    "language:${language.title} created:>${from.format(DateFormats.ofSearchQuery())}"
                )
                .items
                ?.map { response -> response.toModel() } ?: emptyList()
        }
    }

    override suspend fun searchDevelopers(query: String): List<SimpleDeveloper> {
        return withContext(IO) {
            val q = if (query.isNotBlank()) {
                query
            } else {
                "created:>${LocalDateTime.now().minusDays(7).format(DateFormats.ofSearchQuery())}"
            }
            service.getDevelopers(q)
                .items
                ?.map { response -> response.toModel() } ?: emptyList()
        }
    }

    override suspend fun searchRepos(query: String): List<GithubRepository> {
        return withContext(IO) {
            val q = if (query.isNotBlank()) {
                query
            } else {
                "created:>${LocalDateTime.now().minusDays(7).format(DateFormats.ofSearchQuery())}"
            }
            service.getRepositories(q).items?.map { response -> response.toModel() } ?: emptyList()
        }
    }
}