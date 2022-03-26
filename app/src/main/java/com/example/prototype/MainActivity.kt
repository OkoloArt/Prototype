package com.example.prototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import org.w3c.dom.Text
import java.util.*

class MainActivity : LocalizationActivity() {

    var arrayList = 0
    var languageCode = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout: LinearLayout = findViewById(R.id.linear_layout)
        val displayText: TextView = findViewById(R.id.display_language)
        displayText.setText(getLang())
        val list = DataSource().loadLanguages()
        layout.setOnClickListener {
            val show = Locale.getDefault().displayLanguage
            val code = Locale.getDefault().toString()
            for (i in list.indices) {
                if (list[i].name == show || list[i].code == code) {
                    arrayList = list.indexOf(list[i])
                    languageCode = list[i].code
                }
            }
            nextActivity()
        }
    }

    fun getLang():String{
        return getCurrentLanguage().displayLanguage.toString()
    }

    fun nextActivity() {
        val intent = Intent(this, LanguageDetail::class.java)
        intent.putExtra("index", arrayList)
        intent.putExtra("code", languageCode)
        startActivity(intent)
    }
}