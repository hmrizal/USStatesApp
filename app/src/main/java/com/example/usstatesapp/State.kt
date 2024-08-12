package com.example.usstatesapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class State(
    val stateName: String,
    val population: Long,
    val year: Int
) : Parcelable