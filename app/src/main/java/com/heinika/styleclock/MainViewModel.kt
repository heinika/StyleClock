package com.heinika.styleclock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heinika.styleclock.ui.theme.MyFontFamily
import com.heinika.styleclock.ui.theme.Theme
import com.heinika.styleclock.utils.BatteryInfoManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(batteryInfoManager: BatteryInfoManager, private val settingDataStore: SettingDataStore) : ViewModel() {
  private val calendar = Calendar.getInstance().apply {
    time = Date(System.currentTimeMillis())
  }

  private val clockFlow = flow<Calendar> {
    while (true) {
      sleep(1000L)
      calendar.time = Date(System.currentTimeMillis())
      emit(calendar)
    }
  }.flowOn(Dispatchers.IO)


  val theme: Flow<Theme> = settingDataStore.themeFlow

  private val _second: MutableLiveData<Int> = MutableLiveData<Int>(calendar.get(Calendar.SECOND))
  val second: LiveData<Int> = _second

  private val _minute: MutableLiveData<Int> = MutableLiveData<Int>(calendar.get(Calendar.MINUTE))
  val minute: LiveData<Int> = _minute

  private val _hour: MutableLiveData<Int> = MutableLiveData<Int>(calendar.get(Calendar.HOUR))
  val hour: LiveData<Int> = _hour

  private val _amPm: MutableLiveData<Int> = MutableLiveData<Int>(calendar.get(Calendar.AM_PM))
  val amPm: LiveData<Int> = _amPm

  private val _dayOfWeek: MutableLiveData<Int> = MutableLiveData<Int>(calendar.get(Calendar.DAY_OF_WEEK))
  val dayOfWeek: LiveData<Int> = _dayOfWeek

  val isShowBatteryPower: Flow<Boolean> = settingDataStore.isShowBatteryFlow
  val isShowCalendar: Flow<Boolean> = settingDataStore.isShowCalendarFlow

  val fontFamily: Flow<MyFontFamily> = settingDataStore.fontFamilyFlow

  private val _isCharging: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
  val isCharging: LiveData<Boolean> = _isCharging

  private val _powerPct: MutableLiveData<Float> = MutableLiveData<Float>(0.5f)
  val powerPct: LiveData<Float> = _powerPct

  private val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())

  private val _formatDate: MutableLiveData<String> = MutableLiveData<String>(simpleDateFormat.format(calendar.time))
  val formatDate: LiveData<String> = _formatDate

  init {
    val batteryInfo = batteryInfoManager.getInfo()
    _isCharging.value = batteryInfo.isCharging
    _powerPct.value = batteryInfo.powerPct
    batteryInfoManager.onBatteryEvent = {
      _isCharging.value = it.isCharging
      _powerPct.value = it.powerPct
    }

    viewModelScope.launch {
      clockFlow.collect {
        _second.value = calendar.get(Calendar.SECOND)
        if (_minute.value != it.get(Calendar.MINUTE)) {
          _minute.value = it.get(Calendar.MINUTE)

          if (_hour.value != it.get(Calendar.HOUR)) {
            _hour.value = it.get(Calendar.HOUR)

            if (_amPm.value != calendar.get(Calendar.AM_PM)) {
              _amPm.value = calendar.get(Calendar.AM_PM)

              if (_dayOfWeek.value != calendar.get(Calendar.DAY_OF_WEEK)) {
                _dayOfWeek.value = calendar.get(Calendar.DAY_OF_WEEK)
                _formatDate.value = simpleDateFormat.format(calendar.time)
              }
            }
          }
        }
      }
    }
  }

  fun updateTheme(theme: Theme) {
    viewModelScope.launch {
      settingDataStore.updateThemeName(theme.name)
    }
  }

  fun updateMyFontFamily(myFontFamily: MyFontFamily) {
    viewModelScope.launch {
      settingDataStore.updateFontFamilyName(myFontFamily.name)
    }
  }

  fun updateIsShowBatteryPower(isShowBatteryPower: Boolean) {
    viewModelScope.launch {
      settingDataStore.updateIsShowBattery(isShowBatteryPower)
    }
  }

  fun updateIsShowCalendar(isShowCalendar: Boolean) {
    viewModelScope.launch {
      settingDataStore.updateIsShowCalendar(isShowCalendar)
    }
  }

}