package org.weyoung.ad.dto

data class AdPlanRequest(
    val id: Long? = null,
    val userId: Long,
    val planName: String?,
    val startDate: String?,
    val endDate: String?
)