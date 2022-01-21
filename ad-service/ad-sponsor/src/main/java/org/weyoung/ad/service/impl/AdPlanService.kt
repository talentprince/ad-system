package org.weyoung.ad.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.weyoung.ad.constant.*
import org.weyoung.ad.dao.AdPlanRepository
import org.weyoung.ad.dao.AdUserRepository
import org.weyoung.ad.dto.AdPlanGetRequest
import org.weyoung.ad.dto.AdPlanRequest
import org.weyoung.ad.dto.AdPlanResponse
import org.weyoung.ad.entity.AdPlan
import org.weyoung.ad.exception.AdException
import org.weyoung.ad.service.IAdPlanService
import org.weyoung.ad.utils.toDate
import java.util.*

@Service
class AdPlanService(val userRepository: AdUserRepository, val planRepository: AdPlanRepository) : IAdPlanService {

    @Transactional
    override fun createPlan(request: AdPlanRequest): AdPlanResponse {
        if (request.planName == null || request.startDate == null || request.endDate == null)
            throw AdException(REQUEST_PARAM_ERROR)
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

    override fun getAdPlanByIds(request: AdPlanGetRequest): List<AdPlan> =
        planRepository.findAllByIdInAndUserId(request.ids, request.userId)

    @Transactional
    override fun updateAdPlan(request: AdPlanRequest): AdPlanResponse {
        return request.id?.let { id ->
            planRepository.findByIdAndUserId(id, request.userId)?.let { adPlan ->
                adPlan.let { plan ->
                    request.planName?.let { plan.copy(planName = it) } ?: plan
                }.let { plan ->
                    request.startDate?.let { plan.copy(startDate = it.toDate()) } ?: plan
                }.let { plan ->
                    request.endDate?.let { plan.copy(endDate = it.toDate()) } ?: plan
                }
            }?.let(planRepository::save)?.let {
                AdPlanResponse(it.id, it.planName)
            } ?: throw AdException(RECORD_NOT_FOUND)
        } ?: throw AdException(REQUEST_PARAM_ERROR)
    }

    @Transactional
    override fun deleteAdPlan(request: AdPlanRequest) {
        request.id?.let { id ->
            planRepository.findByIdAndUserId(id, request.userId)
                ?.copy(planStatus = CommonStatus.INVALID.status, updateTime = Date())
                ?.let(planRepository::save)
                ?: throw AdException(RECORD_NOT_FOUND)
        } ?: throw AdException(REQUEST_PARAM_ERROR)
    }
}