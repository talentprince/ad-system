package org.weyoung.ad.dto

data class AdUnitLocationRequest(val unitLocations: List<UnitLocation>) {
    data class UnitLocation(val unitId: Long, val province: String, val city: String)
}
