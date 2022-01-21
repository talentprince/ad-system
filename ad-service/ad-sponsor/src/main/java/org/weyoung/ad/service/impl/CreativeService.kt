package org.weyoung.ad.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.weyoung.ad.dao.CreativeRepository
import org.weyoung.ad.dto.CreativeRequest
import org.weyoung.ad.dto.CreativeResponse
import org.weyoung.ad.dto.toEntity
import org.weyoung.ad.service.ICreativeService

@Service
class CreativeService(val creativeRepository: CreativeRepository) : ICreativeService {

    @Transactional
    override fun createAdCreative(request: CreativeRequest): CreativeResponse =
        creativeRepository.save(request.toEntity()).let {
            CreativeResponse(it.id, it.name)
        }
}