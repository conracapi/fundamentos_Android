package com.example.avengersapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// ---
typealias AvengerCharacters = ArrayList<AvengerCharacter>

@Parcelize
data class AvengerCharacter(val image: String, val name: String, var description: String) : Parcelable

