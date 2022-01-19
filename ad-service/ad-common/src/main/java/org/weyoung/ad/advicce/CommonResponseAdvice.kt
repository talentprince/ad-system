package org.weyoung.ad.advicce

import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import org.weyoung.ad.annotation.IgnoreResponseAdvice
import org.weyoung.ad.model.CommonResponse

@RestControllerAdvice
class CommonResponseAdvice : ResponseBodyAdvice<Any> {
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return when {
            returnType.declaringClass.isAnnotationPresent(IgnoreResponseAdvice::class.java) -> false
            returnType.method!!.isAnnotationPresent(IgnoreResponseAdvice::class.java) -> false
            else -> true
        }
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        return body?.takeIf { body !is CommonResponse<*> }?.let {
            CommonResponse(0, "", body)
        } ?: CommonResponse<Any>(0, "")
    }
}