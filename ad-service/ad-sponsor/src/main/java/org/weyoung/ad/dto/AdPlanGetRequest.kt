package org.weyoung.ad.dto

data class AdPlanGetRequest(
    val userId: Long,
    val ids: List<Long>
)