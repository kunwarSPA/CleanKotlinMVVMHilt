package com.kotlin.domain.usecase.login

import com.kotlin.domain.repository.LoginRepository
import io.reactivex.Observable
import javax.inject.Inject
import com.kotlin.domain.entity.EmployeeLoginEntity


class LoginUseCase  @Inject constructor(private val repository: LoginRepository) {

    fun login(id: EmployeeLoginEntity, hasNetwork: Boolean): Observable< com.kotlin.domain.result.Result<String>> {
        return repository.login(id).toObservable().map {
                val data = it

            com.kotlin.domain.result.Result.Success(data) as  com.kotlin.domain.result.Result<String>
            }
                .onErrorReturn {  com.kotlin.domain.result.Result.Failure(it) }
                .startWith( com.kotlin.domain.result.Result.Loading())
    }
}
