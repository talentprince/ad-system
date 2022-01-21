package org.weyoung.ad.service

import org.weyoung.ad.dto.CreativeRequest
import org.weyoung.ad.dto.CreativeResponse

interface ICreativeService {
    fun createAdCreative(request: CreativeRequest): CreativeResponse
}