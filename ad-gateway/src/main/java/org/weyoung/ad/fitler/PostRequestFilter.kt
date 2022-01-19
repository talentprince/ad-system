package org.weyoung.ad.fitler

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants
import org.springframework.stereotype.Component

@Component
class PostRequestFilter : ZuulFilter() {
    override fun shouldFilter(): Boolean = true

    override fun run(): Any? {
        val currentContext = RequestContext.getCurrentContext()
        val request = currentContext.request
        val cost = System.currentTimeMillis() - (currentContext["startTime"] as Long)
        System.out.println("Url ${request.requestURL} takes ${cost / 100}")
        return null
    }

    override fun filterType(): String = FilterConstants.POST_TYPE

    override fun filterOrder(): Int = FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1
}