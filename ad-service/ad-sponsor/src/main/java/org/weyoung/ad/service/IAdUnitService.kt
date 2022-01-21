package org.weyoung.ad.service

import org.weyoung.ad.dto.AdUnitRequest
import org.weyoung.ad.dto.AdUnitResponse

interface IAdUnitService {
    fun createUnit(request: AdUnitRequest): AdUnitResponse
}