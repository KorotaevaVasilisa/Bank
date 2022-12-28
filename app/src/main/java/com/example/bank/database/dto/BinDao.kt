package com.example.bank.database.dto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bank.database.BinEntity

@Dao
interface BinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBin(info: BinEntity)

    @Query("SELECT * FROM bin_table")
    suspend fun getAll(): List<BinEntity>
}
