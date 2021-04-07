package com.touki.moviez.core.features.auth.source

import com.touki.moviez.core.features.auth.domain.UserInfo
import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.usecases.UseCaseResult

/** Created by mentok on 4/6/21 */
interface SignInByUserPassDataSource {
    suspend operator fun invoke(userPass: UserPass) : UseCaseResult<UserInfo>
}