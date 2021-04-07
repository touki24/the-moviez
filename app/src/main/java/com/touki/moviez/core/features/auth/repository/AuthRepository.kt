package com.touki.moviez.core.features.auth.repository

import com.touki.moviez.core.features.auth.domain.UserInfo
import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.features.auth.source.SignInByUserPassDataSource
import com.touki.moviez.core.features.auth.source.ValidateUserPassDataSource
import com.touki.moviez.core.usecases.UseCaseResult

/** Created by mentok on 4/6/21 */
class AuthRepository(
    private val signInByUserPassDataSource: SignInByUserPassDataSource,
    private val validateUserPassDataSource: ValidateUserPassDataSource
) {
    suspend fun signInByUserPass(userPass: UserPass) : UseCaseResult<UserInfo> {
        return signInByUserPassDataSource(userPass)
    }

    fun validateUserPass(userPass: UserPass) : UseCaseResult<UserPass> {
        return validateUserPassDataSource(userPass)
    }
}