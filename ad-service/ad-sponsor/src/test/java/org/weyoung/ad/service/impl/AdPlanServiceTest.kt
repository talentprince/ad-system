package org.weyoung.ad.service.impl

import com.nhaarman.mockito_kotlin.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.weyoung.ad.constant.RECORD_NOT_FOUND
import org.weyoung.ad.constant.SAME_PLAN_NAME_ERROR
import org.weyoung.ad.dao.AdPlanRepository
import org.weyoung.ad.dao.AdUserRepository
import org.weyoung.ad.dto.AdPlanRequest
import org.weyoung.ad.dto.AdPlanResponse
import org.weyoung.ad.entity.AdPlan
import org.weyoung.ad.exception.AdException
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class AdPlanServiceTest {
    @Mock
    lateinit var userRepository: AdUserRepository

    @Mock
    lateinit var planRepository: AdPlanRepository

    @InjectMocks
    lateinit var planService: AdPlanService

    @Test
    internal fun `user not exit when create plan`() {
        //NOTE: can not mock findByIdOrNull cause extension function
        whenever(userRepository.findById(1L)).thenReturn(Optional.empty())

        val e = assertThrows<AdException> {
            planService.createPlan(
                AdPlanRequest(
                    1,
                    1,
                    "planA",
                    Date().toString(),
                    Date().toString()
                )
            )
        }

        assertEquals(RECORD_NOT_FOUND, e.message)
    }

    @Test
    internal fun `plan already exist when create plan`() {
        whenever(userRepository.findById(1L)).thenReturn(Optional.of(mock()))
        whenever(planRepository.findByUserIdAndPlanName(1L, "planA")).thenReturn(mock())

        val e = assertThrows<AdException> {
            planService.createPlan(
                AdPlanRequest(
                    userId = 1L,
                    planName = "planA",
                    startDate = "2022/01/01",
                    endDate = "2022/01/01"
                )
            )
        }

        assertEquals(SAME_PLAN_NAME_ERROR, e.message)
    }

    @Test
    internal fun `create plan success`() {
        whenever(userRepository.findById(1L)).thenReturn(Optional.of(mock()))
        whenever(planRepository.findByUserIdAndPlanName(1L, "planA")).thenReturn(null)
        //NOTE: for generic function parameter mock, we can explicit type or use onGeneric
        planRepository.stub {
            onGeneric { save(any()) } doReturn AdPlan(
                id = 0,
                planName = "planA",
                userId = 1L,
                startDate = Date(),
                endDate = Date()
            )
        }

        val response = planService.createPlan(
            AdPlanRequest(
                userId = 1L,
                planName = "planA",
                startDate = "2022/01/01",
                endDate = "2022/01/01"
            )
        )

        assertEquals(AdPlanResponse(0, "planA"), response)
    }
}