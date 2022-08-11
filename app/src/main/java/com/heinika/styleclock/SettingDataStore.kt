package com.heinika.styleclock

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.heinika.styleclock.ui.theme.MyFontFamily
import com.heinika.styleclock.ui.theme.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Suppress("PrivatePropertyName")
@Singleton
class SettingDataStore @Inject constructor(private val application: Application) {
  private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

  private val IS_SHOW_BATTERY = booleanPreferencesKey("is_show_battery")
  private val IS_SHOW_CALENDAR = booleanPreferencesKey("is_show_calendar")
  private val THEME_NAME_KEY = stringPreferencesKey("theme_key")
  private val FONT_FAMILY_NAME_KEY = stringPreferencesKey("font_family_name_key")

  val isShowBatteryFlow: Flow<Boolean> = application.dataStore.data.map {
    it[IS_SHOW_BATTERY] ?: false
  }

  val isShowCalendarFlow: Flow<Boolean> = application.dataStore.data.map {
    it[IS_SHOW_CALENDAR] ?: false
  }

  val themeFlow: Flow<Theme> = application.dataStore.data.map {
    val themeName = it[THEME_NAME_KEY] ?: Theme.DynamicTheme.name
    Theme.valueOf(themeName)
  }

  val fontFamilyFlow: Flow<MyFontFamily> = application.dataStore.data.map {
    val myFontFamilyName = it[FONT_FAMILY_NAME_KEY] ?: MyFontFamily.DefaultFontFamily.name
    MyFontFamily.valueOf(myFontFamilyName)
  }

  suspend fun updateIsShowBattery(isShowBattery: Boolean) {
    application.dataStore.edit { settings ->
      settings[IS_SHOW_BATTERY] = isShowBattery
    }
  }

  suspend fun updateIsShowCalendar(isShowCalendar: Boolean){
    application.dataStore.edit {settings ->
      settings[IS_SHOW_CALENDAR] = isShowCalendar
    }
  }

  suspend fun updateThemeName(themeName: String) {
    application.dataStore.edit { settings ->
      settings[THEME_NAME_KEY] = themeName
    }
  }

  suspend fun updateFontFamilyName(fontFamilyName: String) {
    application.dataStore.edit { settings ->
      settings[FONT_FAMILY_NAME_KEY] = fontFamilyName
    }
  }
}