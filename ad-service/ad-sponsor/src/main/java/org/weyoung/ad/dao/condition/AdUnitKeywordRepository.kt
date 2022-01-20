package org.weyoung.ad.dao.condition

import org.springframework.data.jpa.repository.JpaRepository
import org.weyoung.ad.entity.condition.AdUnitKeyword

interface AdUnitKeywordRepository : JpaRepository<AdUnitKeyword, Long> {
}