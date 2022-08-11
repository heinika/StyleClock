package com.heinika.styleclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.heinika.styleclock.screen.ClockScreen
import com.heinika.styleclock.screen.SettingScreen
import com.heinika.styleclock.ui.theme.MyFontFamily
import com.heinika.styleclock.ui.theme.PureClockTheme
import com.heinika.styleclock.ui.theme.Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
@ExperimentalMaterial3Api
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    hideSystemUI()

    setContent {
      val theme by viewModel.theme.collectAsState(initial = Theme.DynamicTheme)
      val fontFamily by viewModel.fontFamily.collectAsState(initial = MyFontFamily.DefaultFontFamily)
      val hour by viewModel.hour.observeAsState()
      val minute by viewModel.minute.observeAsState()
      val second by viewModel.second.observeAsState()
      val amPm by viewModel.amPm.observeAsState()
      val dayOfWeek by viewModel.dayOfWeek.observeAsState()
      val powerPct by viewModel.powerPct.observeAsState()
      val isCharging by viewModel.isCharging.observeAsState()
      val formatDate by viewModel.formatDate.observeAsState()
      val isShowBatteryPower by viewModel.isShowBatteryPower.collectAsState(initial = false)
      val isShowCalendar by viewModel.isShowCalendar.collectAsState(initial = false)

      val scope = rememberCoroutineScope()
      PureClockTheme(theme) {
        Scaffold { paddingValues ->
          paddingValues.calculateTopPadding()

          BoxWithConstraints {
            val settingScreenHeightDp = maxHeight.value
            val settingScreenHeight = (settingScreenHeightDp).dp
            val swipeableState = rememberSwipeableState(0)
            val swipeSizePx = with(LocalDensity.current) { -settingScreenHeight.toPx() }
            val anchors = mapOf(0f to 0, swipeSizePx to 1)

            BackHandler(enabled = swipeableState.currentValue == 1) {
              scope.launch {
                swipeableState.animateTo(0)
              }
            }

            if (maxWidth > maxHeight) {
              ConstraintLayout(
                Modifier
                  .fillMaxSize()
                  .swipeable(swipeableState, anchors = anchors, orientation = Orientation.Vertical)
              ) {
                val (clockScreen, settingScreen) = createRefs()
                ClockScreen(
                  orientation = Orientation.Horizontal,
                  modifier = Modifier.constrainAs(clockScreen) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                  },
                  hour = hour!!,
                  amPm = amPm!!,
                  minute = minute!!,
                  second = second!!,
                  dayOfWeek = dayOfWeek!!,
                  powerPct = powerPct!!,
                  isCharging = isCharging!!,
                  isShowBattery = isShowBatteryPower,
                  isShowCalendar = isShowCalendar,
                  formatDate = formatDate!!,
                  fontFamily = fontFamily
                )

                SettingScreen(
                  modifier = Modifier
                    .constrainAs(settingScreen) {
                      start.linkTo(parent.start)
                      top.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
                    .height(settingScreenHeight)
                    .padding(16.dp)
                    .offset(y = (swipeableState.offset.value / -swipeSizePx * settingScreenHeightDp).dp),
                  onColorThemeChange = { viewModel.updateTheme(it) },
                  onCloseClick = {
                    scope.launch {
                      swipeableState.animateTo(0)
                    }
                  },
                  isShowBatteryPower = isShowBatteryPower,
                  onShowPowerChange = {
                    viewModel.updateIsShowBatteryPower(it)
                  },
                  isShowCalendar = isShowCalendar,
                  onShowCalendarChange = {
                    viewModel.updateIsShowCalendar(it)
                  },
                  myFontFamily = fontFamily,
                  onMyFontFamilyChange = {
                    viewModel.updateMyFontFamily(it)
                  },
                  theme = theme
                )
              }
            } else {
              ConstraintLayout(
                Modifier
                  .fillMaxSize()
                  .swipeable(swipeableState, anchors = anchors, orientation = Orientation.Vertical)
              ) {
                val (clockScreen, settingScreen) = createRefs()
                ClockScreen(
                  orientation = Orientation.Vertical,
                  modifier = Modifier.constrainAs(clockScreen) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                  },
                  hour = hour!!,
                  amPm = amPm!!,
                  minute = minute!!,
                  second = second!!,
                  dayOfWeek = dayOfWeek!!,
                  powerPct = powerPct!!,
                  isCharging = isCharging!!,
                  isShowBattery = isShowBatteryPower,
                  isShowCalendar = isShowCalendar,
                  formatDate = formatDate!!,
                  fontFamily = fontFamily
                )

                SettingScreen(
                  modifier = Modifier
                    .constrainAs(settingScreen) {
                      start.linkTo(parent.start)
                      top.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
                    .height(settingScreenHeight)
                    .padding(16.dp)
                    .offset(y = (swipeableState.offset.value / -swipeSizePx * settingScreenHeightDp).dp),
                  theme = theme,
                  onColorThemeChange = { viewModel.updateTheme(it) },
                  onCloseClick = {
                    scope.launch {
                      swipeableState.animateTo(0)
                    }
                  },
                  isShowBatteryPower = isShowBatteryPower,
                  onShowPowerChange = {
                    viewModel.updateIsShowBatteryPower(it)
                  },
                  isShowCalendar = isShowCalendar,
                  onShowCalendarChange = {
                    viewModel.updateIsShowCalendar(it)
                  },
                  myFontFamily = fontFamily,
                  onMyFontFamilyChange = {
                    viewModel.updateMyFontFamily(it)
                  }
                )
              }
            }
          }
        }
      }
    }

  }

  private fun hideSystemUI() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    WindowInsetsControllerCompat(window, window.decorView).let { controller ->
      controller.hide(WindowInsetsCompat.Type.systemBars())
      controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
  }

//  private fun showSystemUI() {
//    WindowCompat.setDecorFitsSystemWindows(window, true)
//    WindowInsetsControllerCompat(window, window.decorView).show(WindowInsetsCompat.Type.systemBars())
//  }
}

