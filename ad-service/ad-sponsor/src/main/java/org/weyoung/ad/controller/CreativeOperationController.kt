package org.weyoung.ad.controller

import com.alibaba.fastjson.JSON
import org.apache.juli.logging.LogFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.weyoung.ad.dto.CreativeRequest
import org.weyoung.ad.dto.CreativeResponse
import org.weyoung.ad.service.ICreativeService

@RestController
class CreativeOperationController(val creativeService: ICreativeService) {
    companion object {
        private val log = LogFactory.getLog(CreativeOperationController::class.java)
    }

    @PostMapping("/create/creative")
    fun createCreative(@RequestBody request: CreativeRequest): CreativeResponse {
        log.info("ad-sponsor: createCreative -> ${JSON.toJSONString(request)}")
        return creativeService.createAdCreative(request)
    }
}