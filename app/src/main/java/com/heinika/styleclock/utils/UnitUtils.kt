package com.heinika.styleclock.utils

import android.content.res.Resources

val Number.toDpValue: Int
  get() = (this.toFloat() / Resources.getSystem().displayMetrics.density + 0.5f).toInt()