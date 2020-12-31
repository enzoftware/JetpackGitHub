package com.enzoftware.mvvmarchexample.database.dao

import androidx.room.*
import com.enzoftware.mvvmarchexample.database.entity.GithubRepositoryEntity


/**
 * Created by Enzo Lizama Paredes on 2020-02-10.
 * Contact: lizama.enzo@gmail.com
 */

@Dao
abstract class RepositoryDao{
    @Query("SELECT * FROM repository")
    abstract suspend fun getAll() : List<GithubRepositoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(githubRepository: GithubRepositoryEntity)

    @Delete
    abstract suspend fun delete(githubRepository: GithubRepositoryEntity)

    @Query("DELETE FROM repository")
    abstract suspend fun deleteAll()
}