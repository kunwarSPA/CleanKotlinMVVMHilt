package com.kotlin.domain.repository

import com.kotlin.domain.entity.EmployeeLoginEntity
import io.reactivex.Single

interface LoginRepository {
    fun login(id: EmployeeLoginEntity): Single<String>
    fun logout(id: String) : Single<String>
}