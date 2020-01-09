package com.enzoftware.mvvmarchexample.util

import java.time.format.DateTimeFormatter


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */

object DateFormatters {

    fun ofApiResult(): DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")

    fun ofSearchQuery(): DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
}