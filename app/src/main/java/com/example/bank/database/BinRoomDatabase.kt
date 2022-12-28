package com.example.bank.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bank.database.dto.BinDao

@Database(entities = arrayOf(BinEntity::class), version = 1, exportSchema = false)
abstract class BinRoomDatabase : RoomDatabase() {

    abstract fun binDao(): BinDao

    companion object {

        @Volatile
        private var INSTANCE: BinRoomDatabase? = null

        fun getDatabase(context: Context): BinRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BinRoomDatabase::class.java,
                    "bins_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
