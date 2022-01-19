package org.weyoung.ad.model

import java.io.Serializable

data class CommonResponse<T>(val code: Int, val message: String, val data: T? = null) : Serializable