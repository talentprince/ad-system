package org.weyoung.ad.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ad_creative")
data class AdCreative(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "type", nullable = false)
    val type: Int,
    @Column(name = "material_type", nullable = false)
    val materialType: Int,
    @Column(name = "size", nullable = false)
    val size: Long,
    @Column(name = "height", nullable = false)
    val height: Int,
    @Column(name = "width", nullable = false)
    val width: Int,
    @Column(name = "duration", nullable = false)
    val duration: Int,
    @Column(name = "audit_status", nullable = false)
    val auditStatus: Int,
    @Column(name = "user_id", nullable = false)
    val userId: Long,
    @Column(name = "url", nullable = false)
    val url: String,
    @get:Column(name = "create_time", nullable = false)
    val createTime: Date = Date(),
    @get:Column(name = "update_time", nullable = false)
    val updateTime: Date = Date()
)