package org.weyoung.ad.entity

import org.weyoung.ad.constant.CommonStatus
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ad_user")
data class AdUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "name", nullable = false)
    val userName: String,
    @Column(name = "token", nullable = false)
    val token: String,
    @Column(name = "user_status", nullable = false)
    val userStatue: Int = CommonStatus.VALID.status,
    @Column(name = "create_time", nullable = false)
    val createTime: Date = Date(),
    @Column(name = "update_time", nullable = false)
    val updateTime: Date = Date()
)