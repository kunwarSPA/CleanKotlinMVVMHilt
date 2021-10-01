package com.kotlin.data.di

import com.kotlin.data.api.LoginAPI
import com.kotlin.data.repository.LoginRepositoryImpl
import com.kotlin.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

 /*  @Provides
    fun provideLoginRepository(repo: LoginRepositoryImpl): LoginRepository = repo
*/

    @Provides
    fun provideLoginRepository(loginApiImpl: LoginAPI): LoginRepository {

        return LoginRepositoryImpl(loginApiImpl)
    }
}