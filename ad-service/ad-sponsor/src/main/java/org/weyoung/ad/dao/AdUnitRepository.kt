package org.weyoung.ad.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.weyoung.ad.entity.AdUnit

interface AdUnitRepository : JpaRepository<AdUnit, Long>{
    fun findByPlanIdAndUnitName(planId: Long, unitName: String): AdUnit?
    fun findAllByUnitStatus(unitStatus: Int): List<AdUnit>
}