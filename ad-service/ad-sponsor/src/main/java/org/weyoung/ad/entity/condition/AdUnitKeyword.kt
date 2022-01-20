package org.weyoung.ad.entity.condition

import javax.persistence.*

@Entity
@Table(name = "ad_unit_keyword")
data class AdUnitKeyword(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "unit_id", nullable = false)
    val unitId: Long,
    @Column(name = "keyword", nullable = false)
    val keyword: String,
)