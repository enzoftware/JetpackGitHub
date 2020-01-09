package com.enzoftware.mvvmarchexample.di.modules

import com.enzoftware.mvvmarchexample.Config
import com.enzoftware.mvvmarchexample.api.*
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */

@Module
open class NetworkModule {

    @Provides
    @Singleton
    open fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(10L, TimeUnit.SECONDS)
            .writeTimeout(10L, TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(ApiTokenInterceptor())
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Config.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    @Singleton
//    @Provides
//    fun providesRepositoryApi(retrofit: Retrofit): RepoApi {
//
//    }

    @Singleton
    @Provides
    fun providesDeveloperApi(retrofit: Retrofit): DeveloperApi {
        return DeveloperApiClient(retrofit)
    }
//
//    @Singleton
//    @Provides
//    fun providesSearchApi(retrofit: Retrofit): SearchApi {
//
//    }
}