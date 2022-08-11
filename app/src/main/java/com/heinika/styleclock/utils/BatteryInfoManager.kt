package com.heinika.styleclock.utils

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.util.Log
import com.heinika.styleclock.model.BatteryInfo
import com.heinika.styleclock.receiver.BatteryLevelReceiver
import javax.inject.Inject

class BatteryInfoManager @Inject constructor(application: Application) {
  val TAG = "BatteryInfoManager"
  var batteryStatus: Intent? = null
  var onBatteryEvent: ((BatteryInfo) -> Unit)? = null

  init {
    batteryStatus = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { iFilter ->
      iFilter.addAction(Intent.ACTION_BATTERY_LOW)
      iFilter.addAction(Intent.ACTION_BATTERY_OKAY)
      iFilter.addAction(Intent.ACTION_POWER_CONNECTED)
      iFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)

      application.registerReceiver(BatteryLevelReceiver, iFilter)
    }
    BatteryLevelReceiver.onBatteryEvent = {
      batteryStatus = it
      onBatteryEvent?.invoke(getInfo())
    }
  }

  fun getInfo(): BatteryInfo {
    val status: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
    val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
        || status == BatteryManager.BATTERY_STATUS_FULL

    // How are we charging?
    val chargePlug: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) ?: -1
    val usbCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
    val acCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_AC

    val batteryPct: Float? = batteryStatus?.let { intent ->
      val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
      val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
      level / scale.toFloat()
    }

    Log.i(TAG, "getInfo: $batteryPct")
    return BatteryInfo(isCharging, usbCharge, acCharge, batteryPct ?: 0.5f)
  }
}