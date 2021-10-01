package com.kotlin.data.request

import com.kotlin.domain.entity.EmployeeLoginEntity

/**
 * Creating kotlin data class that will be used to to update UI when a live data object of the class
 * retrieved from data source.
 * @Entity annotation shows that the class name will be the tableName in Room database.
 * and the declared variable name will be used as column name of the database's table
 * tableName param is optional.
 */

data class EmployeeLogin(
    val name: String,
    val password: String
    )

fun EmployeeLoginEntity.toModel() = EmployeeLogin(this.name, this.password)