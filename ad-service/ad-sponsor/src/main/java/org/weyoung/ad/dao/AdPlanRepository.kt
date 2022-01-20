package org.weyoung.ad.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.weyoung.ad.entity.AdPlan

interface AdPlanRepository : JpaRepository<AdPlan, Long> {
    fun findByIdAndUserId(id: Long, userId: Long): AdPlan?
    fun findAllByIdInAndUserId(ids: List<Long>, userId: Long): List<AdPlan>
    fun findByUserIdAndPlanName(userId: Long, planName: String): AdPlan?
    fun findAllByPlanStatus(status: Int): List<AdPlan>
}