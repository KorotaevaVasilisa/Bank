package com.example.bank.database.dto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bank.database.BinEntity

@Dao
interface BinDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBin(info: BinEntity)

    @Query("SELECT * FROM bin_table ORDER BY id DESC")
    suspend fun getAll(): List<BinEntity>
}
