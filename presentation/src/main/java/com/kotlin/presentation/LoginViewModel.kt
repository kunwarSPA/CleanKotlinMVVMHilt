package com.kotlin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.core.addTo
import com.kotlin.domain.entity.EmployeeLoginEntity
import com.kotlin.domain.usecase.login.LoginUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import com.kotlin.domain.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel(){


     val loginStatus = MutableLiveData<String?>()
    private val disposables = CompositeDisposable()
    val progressVisible = MutableLiveData<Boolean>()

    fun getLogin(employeeLogin: EmployeeLoginEntity) {
        loginUseCase.login(employeeLogin,true) .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleResult(it) }
            .addTo(disposables)
    }


    private fun handleResult(result: Result<String>) {
        when (result) {
            is Result.Loading -> progressVisible.value = true
            is Result.Success -> {

                loginStatus.value = result?.loginStatus
            }
            is Result.Failure -> loginStatus.value
        }
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

}
