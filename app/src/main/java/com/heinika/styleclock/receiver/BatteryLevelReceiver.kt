package com.heinika.styleclock.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

object BatteryLevelReceiver : BroadcastReceiver() {
  var onBatteryEvent: ((Intent) -> Unit)? = null

  override fun onReceive(context: Context?, intent: Intent) {
    Log.i("BatteryLevelReceiver", "onReceive: ")
    onBatteryEvent?.invoke(intent)
  }
}