package com.nasa.space.common.extensions

import android.util.DisplayMetrics

fun Int.dpToPx(displayMetrics: DisplayMetrics): Int =
    (this * displayMetrics.density).toInt()