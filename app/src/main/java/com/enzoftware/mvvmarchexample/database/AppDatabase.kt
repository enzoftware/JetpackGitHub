package com.enzoftware.mvvmarchexample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enzoftware.mvvmarchexample.database.dao.RepositoryDao
import com.enzoftware.mvvmarchexample.database.entity.GithubRepositoryEntity


/**
 * Created by Enzo Lizama Paredes on 2020-02-10.
 * Contact: lizama.enzo@gmail.com
 */

const val DATABASE_VERSION = 1

@Database(entities = [GithubRepositoryEntity::class], version = DATABASE_VERSION,  exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract val repositoryDao: RepositoryDao
}