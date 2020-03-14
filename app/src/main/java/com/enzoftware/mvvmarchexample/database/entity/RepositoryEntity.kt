package com.enzoftware.mvvmarchexample.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Enzo Lizama Paredes on 2020-02-10.
 * Contact: lizama.enzo@gmail.com
 */

@Entity(tableName = "repository")
class RepositoryEntity (
    @PrimaryKey
    var id: Int,
    var name: String,
    var owner: String
)