package com.touki.moviez.framework.features.auth.source

import com.touki.moviez.core.features.auth.domain.UserInfo
import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.features.auth.source.SignInByUserPassDataSource
import com.touki.moviez.core.usecases.UseCaseResult
import com.touki.moviez.framework.features.auth.helper.AuthHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/** Created by mentok on 4/6/21 */
class SignInByUserPassDataSourceImpl: SignInByUserPassDataSource {
    override suspend fun invoke(userPass: UserPass): UseCaseResult<UserInfo> {
        return withContext(Dispatchers.IO) {
            AuthHelper.signInByUserPass(userPass)
        }
    }
}