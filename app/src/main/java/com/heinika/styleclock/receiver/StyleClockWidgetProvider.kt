package com.heinika.styleclock.receiver

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle

class StyleClockWidgetProvider : AppWidgetProvider(){

  override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
    super.onUpdate(context, appWidgetManager, appWidgetIds)
  }

  override fun onAppWidgetOptionsChanged(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetId: Int, newOptions: Bundle?) {
    super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
  }

  override fun onDeleted(context: Context?, appWidgetIds: IntArray?) {
    super.onDeleted(context, appWidgetIds)
  }

  override fun onEnabled(context: Context?) {
    super.onEnabled(context)
  }

  override fun onDisabled(context: Context?) {
    super.onDisabled(context)
  }

  override fun onReceive(context: Context?, intent: Intent?) {
    super.onReceive(context, intent)
  }
}