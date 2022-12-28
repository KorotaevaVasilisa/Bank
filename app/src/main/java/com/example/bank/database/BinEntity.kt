package com.example.bank.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_table")
data class BinEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    @ColumnInfo(name = "bin")
    val bin: String = "",
    @ColumnInfo(name = "brand")
    val brand: String = "",
    @ColumnInfo(name = "country")
    val country: String = "",
    @ColumnInfo(name = "prepaid")
    val prepaid: Boolean = true,
    @ColumnInfo(name = "scheme")
    val scheme: String = "",
    @ColumnInfo(name = "type")
    val type: String = "",
    @ColumnInfo(name = "city_bank")
    val cityBank: String = "",
    @ColumnInfo(name = "name_bank")
    val nameBank: String = "",
    @ColumnInfo(name = "phone_bank")
    val phoneBank: String = "",
    @ColumnInfo(name = "url_bank")
    val urlBank: String = "",
)
