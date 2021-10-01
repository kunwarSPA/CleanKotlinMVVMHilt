package com.kotlin.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.domain.entity.EmployeeLoginEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById<TextView>(R.id.email).text
        val password = findViewById<TextView>(R.id.password).text

        val employeeLogin = EmployeeLoginEntity(username.toString(), password.toString())


        val button = findViewById<Button>(R.id.login_button)
        button.setOnClickListener {
            if (username.isNotEmpty() && password.isNotEmpty())
                viewModel.getLogin(employeeLogin)
        }


        viewModel.loginStatus.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })


    }

}
