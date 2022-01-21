package org.weyoung.ad.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.weyoung.ad.constant.RECORD_NOT_FOUND
import org.weyoung.ad.constant.SAME_NAME_ERROR
import org.weyoung.ad.constant.SAME_PLAN_NAME_ERROR
import org.weyoung.ad.dao.AdPlanRepository
import org.weyoung.ad.dao.AdUserRepository
import org.weyoung.ad.dto.AdPlanGetRequest
import org.weyoung.ad.dto.AdPlanRequest
import org.weyoung.ad.dto.AdPlanResponse
import org.weyoung.ad.entity.AdPlan
import org.weyoung.ad.exception.AdException
import org.weyoung.ad.service.IAdPlanService
import org.weyoung.ad.utils.toDate

@Service
class AdPlanService(val userRepository: AdUserRepository, val planRepository: AdPlanRepository) : IAdPlanService {
    override fun createPlan(request: AdPlanRequest): AdPlanResponse {
        userRepository.findByIdOrNull(request.userId) ?: throw AdException(RECORD_NOT_FOUND)
        return planRepository.findByUserIdAndPlanName(request.userId, request.planName)?.let {
            throw AdException(SAME_PLAN_NAME_ERROR)
        } ?: planRepository.save(
            AdPlan(
                userId = request.userId,
                planName = request.planName,
                startDate = request.startDate.toDate(),
                endDate = request.endDate.toDate()
            )
        ).let {
            AdPlanResponse(it.id, it.planName)
        }
    }

    override fun getAdPlanByIds(request: AdPlanGetRequest): List<AdPlan> {
        TODO("Not yet implemented")
    }

    override fun updateAdPlan(request: AdPlanRequest): AdPlanResponse {
        TODO("Not yet implemented")
    }

    override fun deleteAdPlan(request: AdPlanRequest) {
        TODO("Not yet implemented")
    }
}