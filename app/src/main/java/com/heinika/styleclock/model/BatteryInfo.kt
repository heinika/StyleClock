package com.heinika.styleclock.model

data class BatteryInfo (
  val isCharging: Boolean,
  val usbCharge: Boolean,
  val uacCharge: Boolean,
  val powerPct: Float
)