package com.touki.moviez.core.features.auth.source

import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.usecases.UseCaseResult

/** Created by mentok on 4/7/21 */
interface ValidateUserPassDataSource {
    operator fun invoke(userPass: UserPass) : UseCaseResult<UserPass>
}