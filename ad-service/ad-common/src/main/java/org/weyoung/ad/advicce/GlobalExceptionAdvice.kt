package org.weyoung.ad.advicce

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.weyoung.ad.exception.AdException
import org.weyoung.ad.model.CommonResponse
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class GlobalExceptionAdvice {
    @ExceptionHandler(AdException::class)
    fun handleException(request: HttpServletRequest, exception: AdException): CommonResponse<String> {
        return CommonResponse(-1, "Fatal Error", exception.message)
    }
}