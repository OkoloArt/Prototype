package com.example.prototype

import androidx.annotation.DrawableRes

data class Languages(
    val code: String,
    val name: String,
    @DrawableRes val greenTick: Int
)