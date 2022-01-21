package org.weyoung.ad.utils

import org.apache.http.client.utils.DateUtils
import org.weyoung.ad.exception.AdException
import java.util.*

fun String.toDate(): Date =
    try {
        DateUtils.parseDate(this, arrayOf("yyyy-MM-dd", "yyyy/MM/dd", "yyyy.MM.dd"))
    } catch (e: Exception) {
        throw AdException(e.message!!)
    }
