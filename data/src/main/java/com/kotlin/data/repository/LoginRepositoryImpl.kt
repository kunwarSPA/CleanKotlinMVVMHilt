package com.kotlin.data.repository

import com.kotlin.data.api.LoginAPI
import com.kotlin.data.request.EmployeeLogin
import com.kotlin.data.request.toModel
import com.kotlin.domain.entity.EmployeeLoginEntity
import com.kotlin.domain.repository.LoginRepository
import io.reactivex.Single
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApiImpl: LoginAPI
) : LoginRepository {
    override fun login(id: EmployeeLoginEntity): Single<String> {
        return loginApiImpl.login(id.toModel())
    }

    override fun logout(id: String): Single<String> {
        return loginApiImpl.logout(id)
    }


}