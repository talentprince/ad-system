package org.weyoung.ad.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.weyoung.ad.constant.RECORD_NOT_FOUND
import org.weyoung.ad.constant.SAME_UNIT_NAME_ERROR
import org.weyoung.ad.dao.AdPlanRepository
import org.weyoung.ad.dao.AdUnitRepository
import org.weyoung.ad.dto.AdUnitRequest
import org.weyoung.ad.dto.AdUnitResponse
import org.weyoung.ad.entity.AdUnit
import org.weyoung.ad.exception.AdException
import org.weyoung.ad.service.IAdUnitService

@Service
class AdUnitService(val planRepository: AdPlanRepository, val unitRepository: AdUnitRepository) : IAdUnitService {
    override fun createUnit(request: AdUnitRequest): AdUnitResponse {
        planRepository.findByIdOrNull(request.planId) ?: throw AdException(RECORD_NOT_FOUND)
        unitRepository.findByPlanIdAndUnitName(request.planId, request.unitName) ?: throw AdException(
            SAME_UNIT_NAME_ERROR
        )
        return unitRepository.save(
            AdUnit(
                planId = request.planId,
                unitName = request.unitName,
                positionType = request.positionType,
                budget = request.budget
            )
        ).let {
            AdUnitResponse(it.id, it.unitName)
        }
    }
}