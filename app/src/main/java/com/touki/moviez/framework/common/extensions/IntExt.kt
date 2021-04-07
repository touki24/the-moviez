package com.touki.moviez.framework.common.extensions

import java.text.NumberFormat
import java.util.*

/** Created by touki24 on 10/23/20 */

fun Int.toIdr(): String {
    val sb = StringBuilder(NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(this.toLong()))
    return sb.insert(2, " ").toString()
}