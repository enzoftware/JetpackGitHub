package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.model.Language
import com.enzoftware.mvvmarchexample.model.Repository
import com.enzoftware.mvvmarchexample.model.SimpleDeveloper
import java.time.LocalDateTime


/**
 * Created by Enzo Lizama Paredes on 3/14/20.
 * Contact: lizama.enzo@gmail.com
 */
class SearchApiClient : SearchApi {
    override suspend fun getHotRepos(language: Language, from: LocalDateTime): List<Repository> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getHotDevelopers(
        language: Language,
        from: LocalDateTime
    ): List<SimpleDeveloper> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun searchDevelopers(query: String): List<SimpleDeveloper> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun searchRepos(query: String): List<Repository> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}