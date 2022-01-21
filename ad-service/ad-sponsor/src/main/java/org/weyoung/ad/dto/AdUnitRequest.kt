package org.weyoung.ad.dto

data class AdUnitRequest(val planId: Long, val unitName: String, val positionType: Int, val budget: Long)