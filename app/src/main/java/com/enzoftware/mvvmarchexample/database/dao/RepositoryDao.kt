package com.enzoftware.mvvmarchexample.database.dao

import androidx.room.*
import com.enzoftware.mvvmarchexample.database.entity.RepositoryEntity


/**
 * Created by Enzo Lizama Paredes on 2020-02-10.
 * Contact: lizama.enzo@gmail.com
 */

@Dao
abstract class RepositoryDao{
    @Query("SELECT * FROM repository")
    abstract suspend fun getAll() : List<RepositoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(repository: RepositoryEntity)

    @Delete
    abstract suspend fun delete(repository: RepositoryEntity)

    @Query("DELETE FROM repository")
    abstract suspend fun deleteAll()
}