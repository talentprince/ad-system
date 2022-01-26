package org.weyoung.ad.controller

import com.alibaba.fastjson.JSON
import org.apache.juli.logging.LogFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.weyoung.ad.dto.*
import org.weyoung.ad.service.IAdUnitService

@RestController
class AdUnitOperationController(val adUnitService: IAdUnitService) {
    companion object {
        private val log = LogFactory.getLog(AdUnitOperationController::class.java)
    }

    @PostMapping("/create/ad-unit")
    fun createUnit(@RequestBody request: AdUnitRequest): AdUnitResponse {
        log.info("ad-sponsor: createUnit -> ${JSON.toJSONString(request)}")
        return adUnitService.createUnit(request)
    }

    @PostMapping("/create/unit-keyword")
    fun createUnitKeyword(@RequestBody request: AdUnitKeywordRequest): AdUnitKeywordResponse {
        log.info("ad-sponsor: createUnitKeyword -> ${JSON.toJSONString(request)}")
        return adUnitService.createUnitKeyword(request)
    }

    @PostMapping("/create/unit-interest")
    fun createUnitInterest(@RequestBody request: AdUnitInterestRequest): AdUnitInterestResponse {
        log.info("ad-sponsor: createUnitInterest -> ${JSON.toJSONString(request)}")
        return adUnitService.createUnitInterest(request)
    }

    @PostMapping("/create/unit-location")
    fun createUnitLocation(@RequestBody request: AdUnitLocationRequest): AdUnitLocationResponse {
        log.info("ad-sponsor: createUnitLocation -> ${JSON.toJSONString(request)}")
        return adUnitService.createUnitLocation(request)
    }

    @PostMapping("/create/unit-creative")
    fun createUnitCreative(@RequestBody request: CreativeUnitRequest): CreativeUnitResponse {
        log.info("ad-sponsor: createUnitCreative -> ${JSON.toJSONString(request)}")
        return adUnitService.createCreativeUnit(request)
    }
}