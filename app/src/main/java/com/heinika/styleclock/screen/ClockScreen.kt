package com.heinika.styleclock.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.heinika.styleclock.R
import com.heinika.styleclock.compose.BatteryIcon
import com.heinika.styleclock.compose.Flash
import com.heinika.styleclock.ui.theme.MyFontFamily
import com.heinika.styleclock.utils.toDpValue

@ExperimentalMaterial3Api
@Composable
fun ClockScreen(
  orientation: Orientation,
  modifier: Modifier,
  hour: Int,
  amPm: Int,
  minute: Int,
  second: Int,
  dayOfWeek: Int,
  powerPct: Float,
  isCharging: Boolean,
  isShowBattery: Boolean,
  isShowCalendar: Boolean,
  fontFamily: MyFontFamily,
  formatDate: String
) {
  if (orientation == Orientation.Horizontal) {
    HClockScreen(
      modifier = modifier,
      hour = hour,
      amPm = amPm,
      minute = minute,
      second = second,
      dayOfWeek = dayOfWeek,
      powerPct = powerPct,
      isCharging = isCharging,
      isShowBattery = isShowBattery,
      fontFamily = fontFamily,
      formatDate = formatDate,
      isShowCalendar = isShowCalendar
    )
  } else {
    VClockScreen(
      modifier = modifier,
      hour = hour,
      amPm = amPm,
      minute = minute,
      second = second,
      dayOfWeek = dayOfWeek,
      powerPct = powerPct,
      isCharging = isCharging,
      isShowBattery = isShowBattery,
      isShowCalendar = isShowCalendar,
      formatDate = formatDate,
      fontFamily = fontFamily
    )
  }
}


@ExperimentalMaterial3Api
@Composable
fun HClockScreen(
  modifier: Modifier,
  hour: Int,
  amPm: Int,
  minute: Int,
  second: Int,
  dayOfWeek: Int,
  powerPct: Float,
  isCharging: Boolean,
  isShowBattery: Boolean,
  isShowCalendar: Boolean,
  fontFamily: MyFontFamily,
  formatDate: String
) {
  ConstraintLayout(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.primaryContainer)
  ) {
    val (hourCard, minuteCard, batteryIcon, calenderText) = createRefs()

    if (isShowCalendar) {
      Text(
        text = formatDate, Modifier.constrainAs(calenderText) {
          start.linkTo(hourCard.start)
          bottom.linkTo(hourCard.top)
        },
        style = MaterialTheme.typography.bodySmall,
        fontFamily = fontFamily.fontFamily
      )
    }

    if (isShowBattery) {
      BatteryRow(Modifier.constrainAs(batteryIcon) {
        end.linkTo(hourCard.end)
        bottom.linkTo(hourCard.top)
      }, isCharging, powerPct, fontFamily)
    }

    HourCard(
      Modifier
        .constrainAs(hourCard) {
          top.linkTo(parent.top)
          start.linkTo(parent.start)
          bottom.linkTo(parent.bottom)
          end.linkTo(minuteCard.start)
        }
        .fillMaxWidth(0.38f)
        .aspectRatio(1f),
      hour,
      amPm,
      fontFamily
    )

    MinuteCard(
      Modifier
        .constrainAs(minuteCard) {
          top.linkTo(parent.top)
          start.linkTo(hourCard.end)
          end.linkTo(parent.end)
          bottom.linkTo(parent.bottom)
        }
        .fillMaxWidth(0.38f)
        .aspectRatio(1f),
      minute,
      dayOfWeek,
      second,
      myFontFamily = fontFamily
    )

  }
}


@ExperimentalMaterial3Api
@Composable
fun VClockScreen(
  modifier: Modifier,
  hour: Int,
  amPm: Int,
  minute: Int,
  second: Int,
  dayOfWeek: Int,
  powerPct: Float,
  isCharging: Boolean,
  isShowBattery: Boolean,
  isShowCalendar: Boolean,
  fontFamily: MyFontFamily,
  formatDate: String
) {
  ConstraintLayout(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.primaryContainer)
  ) {
    val (hourCard, minuteCard, batteryIcon, calenderText) = createRefs()

    if (isShowCalendar) {
      Text(
        text = formatDate, Modifier.constrainAs(calenderText) {
          start.linkTo(hourCard.start, 4.dp)
          bottom.linkTo(hourCard.top, 4.dp)
        },
        style = MaterialTheme.typography.bodySmall,
        fontFamily = fontFamily.fontFamily
      )
    }

    if (isShowBattery) {
      BatteryRow(Modifier.constrainAs(batteryIcon) {
        end.linkTo(hourCard.end)
        bottom.linkTo(hourCard.top)
      }, isCharging, powerPct, myFontFamily = fontFamily)
    }

    HourCard(
      Modifier
        .constrainAs(hourCard) {
          top.linkTo(parent.top)
          start.linkTo(parent.start)
          end.linkTo(parent.end)
          bottom.linkTo(minuteCard.top)
        }
        .fillMaxHeight(0.38f)
        .aspectRatio(1f),
      hour,
      amPm,
      myFontFamily = fontFamily
    )

    MinuteCard(
      Modifier
        .constrainAs(minuteCard) {
          top.linkTo(hourCard.bottom)
          start.linkTo(parent.start)
          end.linkTo(parent.end)
          bottom.linkTo(parent.bottom)
        }
        .fillMaxHeight(0.38f)
        .aspectRatio(1f),
      minute,
      dayOfWeek,
      second,
      myFontFamily = fontFamily
    )

  }
}

@ExperimentalMaterial3Api
@Composable
fun HourCard(modifier: Modifier = Modifier, hour: Int, amPm: Int, myFontFamily: MyFontFamily) {
  Card(
    modifier = modifier,
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.primary,
      contentColor = MaterialTheme.colorScheme.onPrimary
    )
  ) {
    var width by remember { mutableStateOf(0) }
    var height by remember { mutableStateOf(0) }
    Box(modifier = Modifier
      .fillMaxSize()
      .onGloballyPositioned {
        width = it.size.width
        height = it.size.height
      }) {

      val hourFormattedText = when (hour) {
        0 -> "12"
        in 1..9 -> "0$hour"
        else -> hour.toString()
      }

      val offsetY = calculateFontFamilyOffSetY(myFontFamily, height)

      Text(
        hourFormattedText,
        Modifier
          .align(Alignment.Center)
          .offset(y = offsetY),
        fontSize = (width.toDpValue / 2).sp,
        fontFamily = myFontFamily.fontFamily
      )
      val isAm = amPm == 0
      val text = if (isAm) "AM" else "PM"
      val position = if (isAm) Alignment.TopStart else Alignment.BottomStart
      Box(
        Modifier
          .align(position)
          .fillMaxHeight(0.33f)
          .fillMaxWidth(0.4f)
      ) {
        Text(
          text,
          Modifier
            .align(Alignment.Center)
            .fillMaxWidth(),
          style = TextStyle(
            fontSize = (width.toDpValue / 6).sp,
            textAlign = TextAlign.Center
          ),
          fontFamily = myFontFamily.fontFamily
        )
      }
    }
  }
}

@ExperimentalMaterial3Api
@Composable
fun MinuteCard(modifier: Modifier = Modifier, number: Int, dayOfWeek: Int, second: Int, myFontFamily: MyFontFamily) {
  Card(
    modifier = modifier,
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.primary,
      contentColor = MaterialTheme.colorScheme.onPrimary
    )
  ) {
    var width by remember { mutableStateOf(0) }
    var height by remember { mutableStateOf(0) }
    Box(modifier = Modifier
      .fillMaxSize()
      .onGloballyPositioned {
        width = it.size.width
        height = it.size.height
      }) {

      val offsetY = calculateFontFamilyOffSetY(myFontFamily, height)

      Text(
        if (number < 10) "0$number" else "$number",
        Modifier
          .align(Alignment.Center)
          .offset(y = offsetY),
        fontSize = (width.toDpValue / 2).sp,
        fontFamily = myFontFamily.fontFamily
      )

      Box(
        Modifier
          .align(Alignment.BottomStart)
          .fillMaxHeight(0.33f)
          .fillMaxWidth(0.4f)
      ) {
        val text = when (dayOfWeek) {
          1 -> stringResource(R.string.Sunday)
          2 -> stringResource(R.string.Monday)
          3 -> stringResource(R.string.Tuesday)
          4 -> stringResource(R.string.Wednesday)
          5 -> stringResource(R.string.Thursday)
          6 -> stringResource(R.string.Friday)
          7 -> stringResource(R.string.Saturday)
          else -> stringResource(R.string.Sunday)
        }
        Text(
          text,
          Modifier
            .align(Alignment.Center)
            .fillMaxWidth(),
          style = TextStyle(
            fontSize = (width.toDpValue / 6).sp,
            textAlign = TextAlign.Center
          ),
          fontFamily = myFontFamily.fontFamily
        )
      }

      Row(
        Modifier
          .align(Alignment.BottomEnd)
          .fillMaxSize(0.33f)
          .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
      ) {
        OneNumberCard(
          Modifier
            .fillMaxHeight(0.67f)
            .aspectRatio(0.67f), second / 10,
          myFontFamily = myFontFamily
        )

        OneNumberCard(
          Modifier
            .fillMaxHeight(0.67f)
            .aspectRatio(0.67f), second % 10,
          myFontFamily = myFontFamily
        )
      }
    }
  }
}

@ExperimentalMaterial3Api
@Composable
fun OneNumberCard(modifier: Modifier = Modifier, number: Int, myFontFamily: MyFontFamily) {
  val cardModifier = if (myFontFamily == MyFontFamily.BungeeshadeFamily) {
    modifier
      .aspectRatio(0.55f)
      .offset(y = 13.dp)
  } else {
    modifier
  }
  Card(
    modifier = cardModifier,
    shape = MaterialTheme.shapes.extraSmall,
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.secondary,
      contentColor = MaterialTheme.colorScheme.onSecondary
    )
  ) {
    var width by remember { mutableStateOf(0) }
    var height by remember { mutableStateOf(0) }
    Box(modifier = Modifier
      .fillMaxSize()
      .onGloballyPositioned {
        width = it.size.width
        height = it.size.height
      }) {
      val offsetY = calculateOneNumOffsetY(myFontFamily, height)
      Text(
        "$number",
        Modifier
          .align(Alignment.Center)
          .offset(y = offsetY), fontSize = (width.toDpValue).sp, fontFamily = myFontFamily.fontFamily
      )
    }
  }
}

@Composable
private fun calculateFontFamilyOffSetY(myFontFamily: MyFontFamily, height: Int) = when (myFontFamily) {
  MyFontFamily.DancingScriptFontFamily -> (-height / 40f).dp
  MyFontFamily.AntonFamily -> (-height / 60f).dp
  MyFontFamily.LobsterFamily -> (height / 70f).dp
  MyFontFamily.Cormorantgaramond -> (-height / 40f).dp
  MyFontFamily.BungeeshadeFamily -> (-height / 25f).dp
  else -> 0.dp
}

@Composable
private fun calculateOneNumOffsetY(myFontFamily: MyFontFamily, height: Int) = when (myFontFamily) {
  MyFontFamily.DancingScriptFontFamily -> (-height / 40f).dp
  MyFontFamily.AntonFamily -> (-height / 30f).dp
  MyFontFamily.LobsterFamily -> (height / 40f).dp
  MyFontFamily.Cormorantgaramond -> (-height / 30f).dp
  MyFontFamily.BungeeshadeFamily -> (-height / 15f).dp
  else -> 0.dp
}

@Composable
fun BatteryRow(modifier: Modifier, isCharging: Boolean, powerPct: Float, myFontFamily: MyFontFamily) {
  Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
    if (isCharging) {
      Icon(imageVector = Flash, contentDescription = "", modifier = Modifier.size(12.dp))
    }
    Text(
      text = "${(powerPct * 100).toInt()}%",
      style = MaterialTheme.typography.bodySmall,
      textAlign = TextAlign.Center,
      modifier = Modifier.offset(y = (-1).dp),
      fontFamily = myFontFamily.fontFamily
    )
    BatteryIcon(Modifier, size = 24, powerPct)
  }
}

