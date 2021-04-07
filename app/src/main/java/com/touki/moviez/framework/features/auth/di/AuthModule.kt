package com.touki.moviez.framework.features.auth.di

import com.touki.moviez.core.features.auth.repository.AuthRepository
import com.touki.moviez.core.usecases.auth.SignInByUserPass
import com.touki.moviez.core.usecases.auth.ValidateUserPass
import com.touki.moviez.framework.features.auth.source.SignInByUserPassDataSourceImpl
import com.touki.moviez.framework.features.auth.source.ValidateUserPassDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/** Created by mentok on 4/6/21 */

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    fun provideSignInByUserPassDataSourceImpl() = SignInByUserPassDataSourceImpl()

    @Provides
    fun provideValidateUserPassDataSourceImpl() = ValidateUserPassDataSourceImpl()

    @Provides
    fun provideAuthRepository(
        signInByUserPassDataSourceImpl: SignInByUserPassDataSourceImpl,
        validateUserPassDataSourceImpl: ValidateUserPassDataSourceImpl
    ) : AuthRepository {
        return AuthRepository(
            signInByUserPassDataSource = signInByUserPassDataSourceImpl,
            validateUserPassDataSource = validateUserPassDataSourceImpl
        )
    }

    @Provides
    fun provideSignInByUserPass(authRepository: AuthRepository) = SignInByUserPass(authRepository)

    @Provides
    fun provideValidateUserPass(authRepository: AuthRepository) = ValidateUserPass(authRepository)
}