package com.heinika.styleclock.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.heinika.styleclock.ui.theme.MyFontFamily
import com.heinika.styleclock.ui.theme.Theme
import com.heinika.styleclock.ui.theme.getThemesBaseSdk

@ExperimentalMaterial3Api
@Composable
fun SettingScreen(
  modifier: Modifier = Modifier,
  onColorThemeChange: (Theme) -> Unit,
  onCloseClick: () -> Unit,
  isShowBatteryPower: Boolean,
  onShowPowerChange: (Boolean) -> Unit,
  isShowCalendar: Boolean,
  onShowCalendarChange: (Boolean) -> Unit,
  myFontFamily: MyFontFamily,
  onMyFontFamilyChange: (MyFontFamily) -> Unit,
  theme: Theme
) {
  Card(modifier) {
    Column {
      Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
          text = "Setting",
          style = MaterialTheme.typography.headlineLarge,
          modifier = Modifier
            .weight(1f)
            .padding(8.dp),
          fontFamily = myFontFamily.fontFamily
        )
        OutlinedButton(
          onClick = { onCloseClick() }, shape = CircleShape,
          modifier = Modifier
            .size(50.dp)
            .padding(8.dp),
          contentPadding = PaddingValues(0.dp),
        ) {
          Icon(imageVector = Icons.Default.Close, contentDescription = "")
        }
      }

      Text(
        text = "Color Theme", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(8.dp), fontFamily = myFontFamily.fontFamily
      )

      LazyHorizontalGrid(
        rows = GridCells.Fixed(2), modifier = Modifier
          .padding(4.dp, 0.dp)
          .height(128.dp)
      ) {
        items(getThemesBaseSdk()) {
          val colorScheme = it.getColorScheme(isSystemInDarkTheme(), LocalContext.current)
          val borderStroke = if (theme == it) BorderStroke(2.5.dp, MaterialTheme.colorScheme.primary) else ButtonDefaults.outlinedButtonBorder
          OutlinedButton(
            onClick = { onColorThemeChange(it) },
            shape = MaterialTheme.shapes.medium,
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier
              .height(56.dp)
              .width(120.dp)
              .padding(4.dp),
            colors = ButtonDefaults.buttonColors(contentColor = colorScheme.background, containerColor = colorScheme.onBackground),
            border = borderStroke
          ) {
            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
              Canvas(modifier = Modifier.size(48.dp), onDraw = {
                drawCircle(
                  brush = Brush.sweepGradient(
                    0f to colorScheme.onPrimary,
                    0.25f to colorScheme.onPrimary,
                    0.25f to colorScheme.secondary,
                    0.5f to colorScheme.secondary,
                    0.5f to colorScheme.primary,
                    1.0f to colorScheme.primary
                  )
                )
              })
              Text(
                text = stringResource(id = it.getTextId()),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
                fontFamily = myFontFamily.fontFamily
              )
            }

          }
        }
      }

      Text(
        text = "Font Family", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(8.dp), fontFamily = myFontFamily.fontFamily
      )

      LazyHorizontalGrid(
        rows = GridCells.Fixed(2), modifier = Modifier
          .padding(4.dp, 0.dp)
          .height(128.dp)
      ) {
        items(MyFontFamily.values()) {
          val borderStroke = if (myFontFamily == it) BorderStroke(2.5.dp, MaterialTheme.colorScheme.primary) else ButtonDefaults.outlinedButtonBorder
          OutlinedButton(
            onClick = { onMyFontFamilyChange(it) },
            shape = MaterialTheme.shapes.medium,
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier
              .height(56.dp)
              .width(120.dp)
              .padding(4.dp),
            border = borderStroke
          ) {
            Text(text = "1234567890", fontFamily = it.fontFamily)
          }
        }
      }

      Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp, 0.dp)) {
        Text(
          text = "Show Battery Power",
          style = MaterialTheme.typography.titleMedium,
          modifier = Modifier.weight(1f),
          fontFamily = myFontFamily.fontFamily
        )
        Switch(checked = isShowBatteryPower, onCheckedChange = {
          onShowPowerChange(it)
        })
      }

      Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp, 0.dp)) {
        Text(
          text = "Show Calendar", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f), fontFamily = myFontFamily.fontFamily
        )
        Switch(checked = isShowCalendar, onCheckedChange = {
          onShowCalendarChange(it)
        })
      }
    }
  }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun SettingScreenPreview() {
  SettingScreen(Modifier, {}, {}, isShowBatteryPower = false, {}, isShowCalendar = true, onShowCalendarChange = {}, MyFontFamily.DefaultFontFamily, {}, Theme.DynamicTheme)
}