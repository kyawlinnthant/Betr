package com.kyawlinnthant.betr.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class IO

    @Provides
    @Singleton
    @IO
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}