package com.kotlin.domain.di

import com.kotlin.domain.repository.LoginRepository
import com.kotlin.domain.usecase.login.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class LoginUseCaseModule {

    @Provides
    fun provideLoginUseCase(repo: LoginRepository): LoginUseCase = LoginUseCase(repo)
}