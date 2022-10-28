package kr.co.lee.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.lee.datasource.MovieRemoteSource
import kr.co.lee.datasource.MovieRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindMovieRemoteSource(source: MovieRemoteSourceImpl): MovieRemoteSource
}