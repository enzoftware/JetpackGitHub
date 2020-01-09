package com.enzoftware.mvvmarchexample.util


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */


abstract class DataResponse<T : Any> {
    abstract fun toModel(): T
}