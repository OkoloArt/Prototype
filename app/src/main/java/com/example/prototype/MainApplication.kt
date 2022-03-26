package com.example.prototype

import android.content.Context
import com.akexorcist.localizationactivity.ui.LocalizationApplication
import java.util.*

class MainApplication: LocalizationApplication() {
    /* ... */
    override fun getDefaultLanguage(context: Context) = Locale.getDefault()
}