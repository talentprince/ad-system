package org.weyoung.ad.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.weyoung.ad.entity.AdCreative

interface CreativeRepository : JpaRepository<AdCreative, Long> {

}