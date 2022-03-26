package com.example.prototype

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LanguageDetail : LocalizationActivity() {

    private lateinit var context: Context
    var languageCode = ""
    var getId = 0
    private val languageList = DataSource().loadLanguages()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_detail)

        recyclerView = findViewById(R.id.recyclerView)

        val adapter = LanguageAdapter(this, languageList) {

            createDialog(it.name, it.code)
        }

        val bundle = intent.extras
        getId = bundle?.getInt("index")!!
        languageCode = bundle?.getString("code")!!

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)
    }

    fun testing(adapterPo: Int, imageView: ImageView) {
        if (getId == adapterPo) {
            imageView.visibility = View.VISIBLE
        } else {
            imageView.visibility = View.INVISIBLE
        }
    }

    fun setLang(code: String) {
        setLanguage(code)
    }

    private fun createDialog(lang: String, code: String) {
        MaterialAlertDialogBuilder(this)
            .setMessage("Language changed to $lang")
            .setPositiveButton(resources.getString(R.string.accept)) { dialog, _ ->
                // Respond to positive button press
                setLang(code)
            }
            .show()
    }
}