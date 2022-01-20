package org.weyoung.ad.entity.condition

import javax.persistence.*

@Entity
@Table(name = "ad_unit_interest")
data class AdUnitInterest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "unit_id", nullable = false)
    val unitId: Long,
    @Column(name = "interest_tag", nullable = false)
    val interestTag: String,
)