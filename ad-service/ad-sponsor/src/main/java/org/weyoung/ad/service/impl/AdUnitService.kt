package org.weyoung.ad.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.weyoung.ad.constant.RECORD_NOT_FOUND
import org.weyoung.ad.constant.REQUEST_PARAM_ERROR
import org.weyoung.ad.constant.SAME_UNIT_NAME_ERROR
import org.weyoung.ad.dao.AdPlanRepository
import org.weyoung.ad.dao.AdUnitRepository
import org.weyoung.ad.dao.condition.AdUnitInterestRepository
import org.weyoung.ad.dao.condition.AdUnitKeywordRepository
import org.weyoung.ad.dao.condition.AdUnitLocationRepository
import org.weyoung.ad.dto.*
import org.weyoung.ad.entity.AdUnit
import org.weyoung.ad.entity.condition.AdUnitInterest
import org.weyoung.ad.entity.condition.AdUnitKeyword
import org.weyoung.ad.entity.condition.AdUnitLocation
import org.weyoung.ad.exception.AdException
import org.weyoung.ad.service.IAdUnitService

@Service
class AdUnitService(
    val planRepository: AdPlanRepository,
    val unitRepository: AdUnitRepository,
    val unitKeywordRepository: AdUnitKeywordRepository,
    val unitInterestRepository: AdUnitInterestRepository,
    val unitLocationRepository: AdUnitLocationRepository
) : IAdUnitService {

    @Transactional
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

    @Transactional
    override fun createUnitKeyword(request: AdUnitKeywordRequest): AdUnitKeywordResponse {
        if (!request.unitKeywords.map { it.unitId }.idsAllExist()) {
            throw AdException(REQUEST_PARAM_ERROR)
        }
        return request.unitKeywords.map { AdUnitKeyword(unitId = it.unitId, keyword = it.keyword) }
            .map(unitKeywordRepository::save)
            .map { it.id }.let { AdUnitKeywordResponse(it) }
    }

    @Transactional
    override fun createUnitInterest(request: AdUnitInterestRequest): AdUnitInterestResponse {
        if (!request.unitInterests.map { it.unitId }.idsAllExist()) {
            throw AdException(REQUEST_PARAM_ERROR)
        }
        return request.unitInterests.map { AdUnitInterest(unitId = it.unitId, interestTag = it.interestTag) }
            .map(unitInterestRepository::save)
            .map { it.id }.let { AdUnitInterestResponse(it) }
    }

    @Transactional
    override fun createUnitLocation(request: AdUnitLocationRequest): AdUnitLocationResponse {
        if (!request.unitLocations.map { it.unitId }.idsAllExist()) {
            throw AdException(REQUEST_PARAM_ERROR)
        }
        return request.unitLocations.map { AdUnitLocation(unitId = it.unitId, province = it.province, city = it.city) }
            .map(unitLocationRepository::save)
            .map { it.id }.let { AdUnitLocationResponse(it) }
    }

    private fun List<Long>.idsAllExist() = unitRepository.findAllById(this).size == HashSet(this).size
}