package com.touki.moviez.framework.features.auth.source

import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.features.auth.source.ValidateUserPassDataSource
import com.touki.moviez.core.usecases.UseCaseResult
import com.touki.moviez.framework.features.auth.helper.AuthHelper

/** Created by mentok on 4/7/21 */
class ValidateUserPassDataSourceImpl: ValidateUserPassDataSource {
    override fun invoke(userPass: UserPass): UseCaseResult<UserPass> {
        return AuthHelper.validateUserPass(userPass)
    }
}