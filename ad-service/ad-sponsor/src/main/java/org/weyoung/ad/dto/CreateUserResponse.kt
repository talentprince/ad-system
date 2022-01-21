package org.weyoung.ad.dto

import java.util.*

data class CreateUserResponse(
    val userId: Long,
    val userName: String,
    val token: String,
    val createTime: Date,
    val updateTime: Date
)