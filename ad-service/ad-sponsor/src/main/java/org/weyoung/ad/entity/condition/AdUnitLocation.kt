package org.weyoung.ad.entity.condition

import javax.persistence.*

@Entity
@Table(name = "ad_unit_location")
data class AdUnitLocation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "unit_id", nullable = false)
    val unitId: Long,
    @Column(name = "province", nullable = false)
    val province: String,
    @Column(name = "city", nullable = false)
    val city: String
)