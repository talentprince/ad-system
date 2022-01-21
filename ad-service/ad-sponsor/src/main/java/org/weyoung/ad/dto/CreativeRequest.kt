package org.weyoung.ad.dto

import org.weyoung.ad.constant.CommonStatus
import org.weyoung.ad.entity.AdCreative
import org.weyoung.ad.entity.condition.CreativeUnit
import java.util.*

data class CreativeRequest(
    val name: String,
    val type: Int,
    val materialType: Int,
    val height: Int,
    val width: Int,
    val size: Long,
    val duration: Int,
    val userId: Long,
    val url: String
)

fun CreativeRequest.toEntity() =
    AdCreative(
        name = name,
        type = type,
        materialType = materialType,
        height = height,
        width = width,
        size = size,
        duration = duration,
        userId = userId,
        url = url,
        auditStatus = CommonStatus.VALID.status,
        createTime = Date(),
        updateTime = Date()
    )