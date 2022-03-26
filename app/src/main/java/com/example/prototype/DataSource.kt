package com.example.prototype

class DataSource {

    fun loadLanguages(): List<Languages> {
        return listOf(
            Languages("de","German", R.drawable.ic_check_circle),
            Languages("ja","Japanese", R.drawable.ic_check_circle),
            Languages("fr","French", R.drawable.ic_check_circle),
            Languages("nl","Dutch", R.drawable.ic_check_circle),
            Languages("en","English",R.drawable.ic_check_circle)
        )
    }
}