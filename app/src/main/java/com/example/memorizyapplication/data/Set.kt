package com.example.memorizyapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "sets")
data class Set (
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,    // присваиваем значение, чтобы работало autoGenerate

    val name: String,
    val cardsNumber: Int,
    val description: String
)