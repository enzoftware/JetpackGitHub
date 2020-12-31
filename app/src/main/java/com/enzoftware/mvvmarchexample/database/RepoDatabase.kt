package com.enzoftware.mvvmarchexample.database

import com.enzoftware.mvvmarchexample.model.SimpleRepository


/**
 * Created by Enzo Lizama Paredes on 2020-02-10.
 * Contact: lizama.enzo@gmail.com
 */

interface RepoDatabase {
    /**
     * Get all [SimpleRepository] from local database
     * @return List of [SimpleRepository]
     */
    suspend fun getAll(): List<SimpleRepository>

    /**
     * Insert repository into database
     * @param repository
     */
    suspend fun insert(repository: SimpleRepository)

    /**
     * Delete a [SimpleRepository] from database
     * @param
     */
    suspend fun delete(repository: SimpleRepository)

    /**
     * Delete all [SimpleRepository] from local database
     */
    suspend fun deleteAll()
}