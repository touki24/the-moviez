package com.touki.moviez.core.usecases.auth

import com.touki.moviez.core.features.auth.domain.UserInfo
import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.features.auth.repository.AuthRepository
import com.touki.moviez.core.usecases.UseCaseResult

/** Created by mentok on 4/6/21 */
class SignInByUserPass(private val authRepository: AuthRepository) {
    suspend operator fun invoke(userPass: UserPass) : UseCaseResult<UserInfo> {
        return authRepository.signInByUserPass(userPass)
    }
}