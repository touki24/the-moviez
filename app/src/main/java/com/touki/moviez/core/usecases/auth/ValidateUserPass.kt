package com.touki.moviez.core.usecases.auth

import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.features.auth.repository.AuthRepository
import com.touki.moviez.core.usecases.UseCaseResult

/** Created by mentok on 4/7/21 */
class ValidateUserPass(private val authRepository: AuthRepository) {
    operator fun invoke(userPass: UserPass) : UseCaseResult<UserPass> {
        return authRepository.validateUserPass(userPass)
    }
}