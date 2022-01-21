package org.weyoung.ad.service

import org.weyoung.ad.dto.CreateUserRequest
import org.weyoung.ad.dto.CreateUserResponse

interface IUserService {
    fun createUser(request: CreateUserRequest): CreateUserResponse
}