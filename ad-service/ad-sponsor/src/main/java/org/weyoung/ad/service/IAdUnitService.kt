package org.weyoung.ad.service

import org.weyoung.ad.dto.*

interface IAdUnitService {
    fun createUnit(request: AdUnitRequest): AdUnitResponse
    fun createUnitKeyword(request: AdUnitKeywordRequest): AdUnitKeywordResponse
    fun createUnitInterest(request: AdUnitInterestRequest): AdUnitInterestResponse
    fun createUnitLocation(request: AdUnitLocationRequest): AdUnitLocationResponse
}