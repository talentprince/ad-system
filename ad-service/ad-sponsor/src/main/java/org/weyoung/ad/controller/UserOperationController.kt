package org.weyoung.ad.controller

import com.alibaba.fastjson.JSON
import org.apache.juli.logging.LogFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.weyoung.ad.dto.CreateUserRequest
import org.weyoung.ad.dto.CreateUserResponse
import org.weyoung.ad.service.IUserService

@RestController
class UserOperationController(val userService: IUserService) {
    companion object {
        private val log = LogFactory.getLog(UserOperationController::class.java)
    }

    @PostMapping("/create/user")
    fun createUser(@RequestBody request: CreateUserRequest): CreateUserResponse {
        log.info("ad-sponsor: createUser -> ${JSON.toJSONString(request)}")
        return userService.createUser(request)
    }
}