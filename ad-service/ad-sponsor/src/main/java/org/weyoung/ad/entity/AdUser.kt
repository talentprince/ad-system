package org.weyoung.ad.entity

import org.weyoung.ad.constant.CommonStatus
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ad_user")
data class AdUser(
    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(name = "id", nullable = false)
    val id: Long = 0,
    @get:Column(name = "name", nullable = false)
    val userName: String,
    @get:Column(name = "token", nullable = false)
    val token: String,
    @get:Column(name = "user_status", nullable = false)
    val userStatue: Int = CommonStatus.VALID.status,
    @get:Column(name = "create_time", nullable = false)
    val createTime: Date = Date(),
    @get:Column(name = "update_time", nullable = false)
    val updateTime: Date = Date()
)