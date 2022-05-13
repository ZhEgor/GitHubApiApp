package com.example.githubapiapp.di.module

import com.example.githubapiapp.data.datasource.retrofit.RepoRetrofitDataSource
import com.example.githubapiapp.data.datasource.retrofit.UserRetrofitDataSource
import com.example.githubapiapp.domain.datasource.RepoFetcher
import com.example.githubapiapp.domain.datasource.UserFetcher
import com.example.githubapiapp.domain.datasource.retrofit.api.ApiGitHub
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val API_GIT_HUB_URL = "https://api.github.com"

val dataModule = module {

    // Retrofit dependencies
    factory { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }
    factory { provideOkHttpClient(get()) }
    factory { provideRetrofit(get()) }
    factory { provideApiGitHub(get()) }

    // RetrofitDataSource
    single<RepoFetcher> { RepoRetrofitDataSource(get()) }
    single<UserFetcher> { UserRetrofitDataSource(get()) }
}

private fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(API_GIT_HUB_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

private fun provideApiGitHub(retrofit: Retrofit): ApiGitHub {
    return retrofit.create(ApiGitHub::class.java)
}