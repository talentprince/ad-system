package org.weyoung.ad.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.weyoung.ad.entity.AdUser

interface AdUserRepository : JpaRepository<AdUser, Long> {
    fun findByUserName(userName: String): AdUser?
}