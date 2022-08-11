package com.heinika.styleclock.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BatteryIcon(modifier: Modifier = Modifier, size: Int, batteryPercent: Float) {
  Box(modifier = modifier.size(size.dp)) {
    Icon(imageVector = OutlineBattery, "", modifier = Modifier.fillMaxSize())
    val color = MaterialTheme.colorScheme.primary
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
      drawRect(color, topLeft = Offset(4.dp.toPx() * size / 24f, 8.dp.toPx() * size / 24f), size = Size(12.5.dp.toPx() * size / 24f * batteryPercent, 8.dp.toPx() * size / 24f))
    })
  }
}

@Preview
@Composable
fun BatteryIconPreview() {
  BatteryIcon(batteryPercent = 0.75f, size = 48)
}

public val OutlineBattery: ImageVector
  get() {
    if (_battery != null) {
      return _battery!!
    }
    _battery = Builder(
      name = "Battery", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
      viewportWidth = 24.0f, viewportHeight = 24.0f
    ).apply {
      path(
        fill = SolidColor(Color(0xFF000000)), stroke = null, fillAlpha = 0.0f, strokeAlpha
        = 0.0f, strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
        strokeLineMiter = 4.0f, pathFillType = NonZero
      ) {
        moveTo(0.0f, 0.0f)
        horizontalLineToRelative(24.0f)
        verticalLineToRelative(24.0f)
        horizontalLineToRelative(-24.0f)
        close()
      }
      path(
        fill = SolidColor(Color(0xFF231f20)), stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
        pathFillType = NonZero
      ) {
        moveTo(15.83f, 6.0f)
        horizontalLineTo(4.17f)
        arcTo(2.31f, 2.31f, 0.0f, false, false, 2.0f, 8.43f)
        verticalLineToRelative(7.14f)
        arcTo(2.31f, 2.31f, 0.0f, false, false, 4.17f, 18.0f)
        horizontalLineTo(15.83f)
        arcTo(2.31f, 2.31f, 0.0f, false, false, 18.0f, 15.57f)
        verticalLineTo(8.43f)
        arcTo(2.31f, 2.31f, 0.0f, false, false, 15.83f, 6.0f)
        close()
        moveTo(16.0f, 15.57f)
        arcToRelative(0.52f, 0.52f, 0.0f, false, true, -0.17f, 0.43f)
        horizontalLineTo(4.18f)
        arcTo(0.5f, 0.5f, 0.0f, false, true, 4.0f, 15.57f)
        verticalLineTo(8.43f)
        arcTo(0.53f, 0.53f, 0.0f, false, true, 4.17f, 8.0f)
        horizontalLineTo(15.82f)
        arcToRelative(0.5f, 0.5f, 0.0f, false, true, 0.18f, 0.43f)
        close()
      }
      path(
        fill = SolidColor(Color(0xFF231f20)), stroke = null, strokeLineWidth = 0.0f,
        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
        pathFillType = NonZero
      ) {
        moveTo(21.0f, 9.0f)
        arcToRelative(1.0f, 1.0f, 0.0f, false, false, -1.0f, 1.0f)
        verticalLineToRelative(4.0f)
        arcToRelative(1.0f, 1.0f, 0.0f, false, false, 2.0f, 0.0f)
        verticalLineTo(10.0f)
        arcTo(1.0f, 1.0f, 0.0f, false, false, 21.0f, 9.0f)
        close()
      }
    }
      .build()
    return _battery!!
  }

private var _battery: ImageVector? = null