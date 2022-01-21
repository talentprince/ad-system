package org.weyoung.ad.dto

data class CreativeUnitRequest(val unitItems: List<CreativeUnitItem>) {
    data class CreativeUnitItem(val creativeId: Long, val unitId: Long)
}