package org.weyoung.ad.entity

import org.weyoung.ad.constant.CommonStatus
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ad_plan")
data class AdPlan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "user_id", nullable = false)
    val userId: Long,
    @Column(name = "plan_name", nullable = false)
    val planName: String,
    @Column(name = "plan_status", nullable = false)
    val planStatus: Int = CommonStatus.VALID.status,
    @Column(name = "start_date", nullable = false)
    val startDate: Date,
    @Column(name = "end_date", nullable = false)
    val endDate: Date,
    @Column(name = "end_date", nullable = false)
    val createTime: Date = Date(),
    @Column(name = "end_date", nullable = false)
    val updateTime: Date = Date()
)