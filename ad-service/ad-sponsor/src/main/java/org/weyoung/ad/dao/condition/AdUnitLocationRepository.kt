package org.weyoung.ad.dao.condition

import org.springframework.data.jpa.repository.JpaRepository
import org.weyoung.ad.entity.condition.AdUnitLocation

interface AdUnitLocationRepository : JpaRepository<AdUnitLocation, Long> {
}