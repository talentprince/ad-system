package org.weyoung.ad.constant

sealed class CommonStatus(val status: Int, val desc: String) {
    object VALID : CommonStatus(1, "有效状态")
    object INVALID : CommonStatus(0, "无效状态")
}