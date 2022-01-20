package org.weyoung.ad.constant

sealed class CreativeType(val type: Int, val dest: String) {
    object IMAGE : CreativeType(1, "图片")
    object VIDEO : CreativeType(2, "视频")
    object TEXT : CreativeType(3, "文本")
}