package com.abelsalcedo.appcomida.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Eat(
    val imagen: String = "",
    val nombre: String = "",
    val descripcion: String = ""
): Parcelable