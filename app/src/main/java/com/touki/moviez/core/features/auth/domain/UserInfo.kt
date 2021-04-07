package com.touki.moviez.core.features.auth.domain

/** Created by mentok on 4/6/21 */
data class UserInfo(
    val firstName: String,
    val lastName: String,
    val username: String,
    val token: String
)