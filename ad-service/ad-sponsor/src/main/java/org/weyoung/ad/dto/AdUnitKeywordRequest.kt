package org.weyoung.ad.dto

data class AdUnitKeywordRequest(val unitKeywords: List<UnitKeyword>) {
    data class UnitKeyword(val unitId: Long, val keyword: String)
}
