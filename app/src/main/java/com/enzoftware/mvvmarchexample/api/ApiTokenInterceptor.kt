package com.enzoftware.mvvmarchexample.api

import com.enzoftware.mvvmarchexample.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */

class ApiTokenInterceptor : Interceptor{
    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = BuildConfig.API_KEY
        val builder = chain.request().newBuilder()
        if (token.isNotBlank() && token != "null"){
            builder.addHeader(AUTHORIZATION_HEADER, "token $token")
        }
        return chain.proceed(builder.build())
    }
}