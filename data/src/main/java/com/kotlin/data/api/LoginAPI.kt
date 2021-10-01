package com.kotlin.data.api

import com.kotlin.data.request.EmployeeLogin
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginAPI {

    @POST("api/login")
    fun login(@Body employeeLogin: EmployeeLogin): Single<String>


    @GET("api/logout/{id}")
    fun logout(@Path("id") id: String): Single<String>
}