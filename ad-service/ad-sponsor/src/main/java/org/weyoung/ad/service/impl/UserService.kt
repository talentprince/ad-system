package org.weyoung.ad.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.weyoung.ad.constant.SAME_NAME_ERROR
import org.weyoung.ad.dao.AdUserRepository
import org.weyoung.ad.dto.CreateUserRequest
import org.weyoung.ad.dto.CreateUserResponse
import org.weyoung.ad.entity.AdUser
import org.weyoung.ad.exception.AdException
import org.weyoung.ad.service.IUserService
import java.util.*

@Service
class UserService(val userRepository: AdUserRepository) : IUserService {

    @Transactional
    override fun createUser(request: CreateUserRequest): CreateUserResponse {
        val oldUser = userRepository.findByUserName(request.userName)
        if (oldUser != null) {
            throw AdException(SAME_NAME_ERROR)
        }
        return userRepository.save(AdUser(userName = request.userName, token = UUID.randomUUID().toString())).let {
            CreateUserResponse(it.id, it.userName, it.token, it.createTime, it.updateTime)
        }
    }
}