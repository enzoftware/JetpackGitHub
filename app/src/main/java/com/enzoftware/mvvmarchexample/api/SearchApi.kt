package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.model.Language
import com.enzoftware.mvvmarchexample.model.GithubRepository
import com.enzoftware.mvvmarchexample.model.SimpleDeveloper
import java.time.LocalDateTime


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */

interface SearchApi {
    suspend fun getHotRepos(language: Language, from: LocalDateTime): List<GithubRepository>

    suspend fun getHotDevelopers(language: Language, from: LocalDateTime): List<SimpleDeveloper>

    suspend fun searchDevelopers(query: String): List<SimpleDeveloper>

    suspend fun searchRepos(query: String): List<GithubRepository>
}