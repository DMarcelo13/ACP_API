package com.scrummaster.arboretocarmelopalma.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.scrummaster.arboretocarmelopalma.retrofit.TreeRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RetrofitModule {

    @Singleton
    @Provides
    fun providesGsonBuilder(): Gson{
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://api-arboreto.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideTreeService(retrofit: Retrofit.Builder): TreeRetrofit{
        return retrofit.build().create(TreeRetrofit::class.java)
    }
}