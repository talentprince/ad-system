package org.weyoung.ad.dto

data class AdUnitInterestRequest(val unitInterests: List<UnitInterest>) {
    data class UnitInterest(val unitId: Long, val interestTag: String)
}
