package com.enzoftware.mvvmarchexample.database

import com.enzoftware.mvvmarchexample.database.dao.RepositoryDao
import com.enzoftware.mvvmarchexample.database.entity.RepositoryEntity
import com.enzoftware.mvvmarchexample.model.Repository
import com.enzoftware.mvvmarchexample.model.SimpleRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext


/**
 * Created by Enzo Lizama Paredes on 2020-02-10.
 * Contact: lizama.enzo@gmail.com
 */

class RepoDatabaseClient(private val repositoryDao: RepositoryDao) : RepoDatabase{

    override suspend fun getAll(): List<SimpleRepository> {
        return withContext(IO){
            repositoryDao.getAll()
                .map { entity -> SimpleRepository(entity.id, entity.name, entity.owner) }
        }
    }

    override suspend fun insert(repository: SimpleRepository) {
        return withContext(IO){
            repositoryDao.insert(RepositoryEntity(repository.id, repository.name, repository.owner))
        }
    }

    override suspend fun delete(repository: SimpleRepository) {
        return withContext(IO){
            repositoryDao.delete(RepositoryEntity(repository.id, repository.name, repository.owner))
        }
    }

    override suspend fun deleteAll() {
        return withContext(IO){
            repositoryDao.deleteAll()
        }
    }

}