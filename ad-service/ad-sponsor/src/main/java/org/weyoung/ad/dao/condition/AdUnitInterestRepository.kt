package org.weyoung.ad.dao.condition

import org.springframework.data.jpa.repository.JpaRepository
import org.weyoung.ad.entity.condition.AdUnitInterest

interface AdUnitInterestRepository : JpaRepository<AdUnitInterest, Long> {
}