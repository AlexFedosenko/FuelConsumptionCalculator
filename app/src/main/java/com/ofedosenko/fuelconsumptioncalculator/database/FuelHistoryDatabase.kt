package com.ofedosenko.fuelconsumptioncalculator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ofedosenko.fuelconsumptioncalculator.dao.FuelRecordDao
import com.ofedosenko.fuelconsumptioncalculator.model.RefillRecord



@Database(entities = [RefillRecord::class], version = 1)
abstract class FuelHistoryDatabase : RoomDatabase() {

    internal abstract fun fuelRecordDao(): FuelRecordDao

    companion object {
        internal const val FUEL_HISTORY_TABLE = "fuelHistory"

        private const val FUEL_HISTORY_DB = "fuelHistory.db"

        private var INSTANCE: FuelHistoryDatabase? = null

        fun getInstance(context: Context): FuelHistoryDatabase? {
            if (INSTANCE == null) {
                synchronized(FuelHistoryDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            FuelHistoryDatabase::class.java, FUEL_HISTORY_DB)
                            .build()
                }
            }
            return INSTANCE
        }
    }
}