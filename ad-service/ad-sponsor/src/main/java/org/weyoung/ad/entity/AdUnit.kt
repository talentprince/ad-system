package org.weyoung.ad.entity

import org.weyoung.ad.constant.CommonStatus
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ad_unit")
data class AdUnit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "plan_id", nullable = false)
    val planId: Long,
    @Column(name = "unit_name", nullable = false)
    val unitName: String,
    @Column(name = "unit_status", nullable = false)
    val unitStatus: Int = CommonStatus.VALID.status,
    @Column(name = "position_type", nullable = false)
    val positionType: Int,
    @Column(name = "budget", nullable = false)
    val budget: Long,
    @Column(name = "end_date", nullable = false)
    val createTime: Date = Date(),
    @Column(name = "end_date", nullable = false)
    val updateTime: Date = Date()
)