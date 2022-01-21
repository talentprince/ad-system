package org.weyoung.ad.controller

import com.alibaba.fastjson.JSON
import org.apache.juli.logging.LogFactory
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.weyoung.ad.dto.AdPlanGetRequest
import org.weyoung.ad.dto.AdPlanRequest
import org.weyoung.ad.dto.AdPlanResponse
import org.weyoung.ad.entity.AdPlan
import org.weyoung.ad.service.IAdPlanService

@RestController
class AdPlanOperationController(val adPlanService: IAdPlanService) {
    companion object {
        private val log = LogFactory.getLog(AdPlanOperationController::class.java)
    }

    @PostMapping("/create/ad-plan")
    fun createAdPlan(@RequestBody request: AdPlanRequest): AdPlanResponse {
        log.info("ad-sponsor: createAdPlan-> ${JSON.toJSONString(request)}")
        return adPlanService.createPlan(request)
    }

    @PostMapping("/get/ad-plan")
    fun getAdPlanByIds(@RequestBody request: AdPlanGetRequest): List<AdPlan> {
        log.info("ad-sponsor: getAdPlanByIds -> ${JSON.toJSONString(request)}")
        return adPlanService.getAdPlanByIds(request)
    }

    @PostMapping("/update/ad-plan")
    fun updateAdPlan(@RequestBody request: AdPlanRequest): AdPlanResponse {
        log.info("ad-sponsor: updateAdPlan -> ${JSON.toJSONString(request)}")
        return adPlanService.updateAdPlan(request)
    }

    @DeleteMapping("/delete/ad-plan")
    fun deleteAdPlan(@RequestBody request: AdPlanRequest) {
        log.info("ad-sponsor: updateAdPlan -> ${JSON.toJSONString(request)}")
        adPlanService.deleteAdPlan(request)
    }
}