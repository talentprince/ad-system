package org.weyoung.ad.service

import org.weyoung.ad.dto.AdPlanGetRequest
import org.weyoung.ad.dto.AdPlanRequest
import org.weyoung.ad.dto.AdPlanResponse
import org.weyoung.ad.entity.AdPlan

interface IAdPlanService {
    fun createPlan(request: AdPlanRequest): AdPlanResponse
    fun getAdPlanByIds(request: AdPlanGetRequest): List<AdPlan>
    fun updateAdPlan(request: AdPlanRequest): AdPlanResponse
    fun deleteAdPlan(request: AdPlanRequest)
}