package com.touki.moviez.framework.features.auth.helper

import com.touki.moviez.core.features.auth.domain.UserInfo
import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.usecases.UseCaseResult


object AuthHelper {

    private const val FIRSTNAME = "Nata"
    private const val LASTNAME = "Qentoled"
    private const val USERNAME = "natmiko"
    private const val PASSWORD = "natasalep"
    private const val TOKEN = "dummy_token_svd"

    /**
     * username and password is invalid when:
     * 1. username is empty
     * 2. password is empty
     * */
    fun validateUserPass(userPass: UserPass) : UseCaseResult<UserPass> {
        if (userPass.username.isEmpty() || userPass.username.isBlank())
            return UseCaseResult.Failure("101", "Username cannot be empty.")

        if (userPass.password.isEmpty() || userPass.password.isBlank())
            return UseCaseResult.Failure("201", "Password cannot be empty.")

        return UseCaseResult.Success(userPass)
    }

    /**
     * sign in failure when:
     * 1. username is not registered
     * 2. password is not match
     *
     * */
    fun signInByUserPass(userPass: UserPass): UseCaseResult<UserInfo> {

        if (userPass.username != USERNAME)
            return UseCaseResult.Failure("102","Username is not registered.")

        if (userPass.password != PASSWORD )
            return UseCaseResult.Failure("202", "Wrong password.")

        return UseCaseResult.Success(
            UserInfo(
                firstName = FIRSTNAME,
                lastName = LASTNAME,
                username = userPass.username,
                token = TOKEN
            )
        )
    }
}