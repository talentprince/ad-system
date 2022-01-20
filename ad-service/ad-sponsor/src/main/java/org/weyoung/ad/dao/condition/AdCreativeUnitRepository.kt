package org.weyoung.ad.dao.condition

import org.springframework.data.jpa.repository.JpaRepository
import org.weyoung.ad.entity.AdCreative
import org.weyoung.ad.entity.condition.AdUnitInterest
import org.weyoung.ad.entity.condition.CreativeUnit

interface AdCreativeUnitRepository : JpaRepository<CreativeUnit, Long> {
}