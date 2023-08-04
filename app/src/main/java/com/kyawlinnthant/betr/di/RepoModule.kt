package com.kyawlinnthant.betr.di

import com.kyawlinnthant.betr.repo.Repo
import com.kyawlinnthant.betr.repo.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    @Singleton
    fun bindRepo(repo: RepoImpl): Repo
}