package org.weyoung.ad.fitler

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import lombok.extern.slf4j.Slf4j
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants
import org.springframework.stereotype.Component

@Slf4j
@Component
class PreRequestFilter : ZuulFilter() {
    override fun shouldFilter(): Boolean = true

    override fun run(): Any? {
        val requestContext = RequestContext.getCurrentContext()
        requestContext.set("startTime", System.currentTimeMillis())
        return null
    }

    override fun filterType(): String = FilterConstants.PRE_TYPE

    override fun filterOrder(): Int = 0
}