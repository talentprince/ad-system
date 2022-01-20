package org.weyoung.ad.entity.condition

import javax.persistence.*

@Entity
@Table(name = "ad_creative_unit")
data class CreativeUnit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "unit_id", nullable = false)
    val unitId: Long,
    @Column(name = "creative_id", nullable = false)
    val creativeId: String
)