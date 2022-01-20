package org.weyoung.ad.constant

sealed class CreativeMaterialType(val type: Int, val dest: String) {
    object JPG : CreativeMaterialType(1, "jpg")
    object BMP : CreativeMaterialType(2, "bmp")
    object MP4 : CreativeMaterialType(3, "mp4")
    object AVI : CreativeMaterialType(3, "avi")
    object TXT : CreativeMaterialType(3, "txt")
}