package com.ofedosenko.fuelconsumptioncalculator.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ofedosenko.fuelconsumptioncalculator.database.FuelHistoryDatabase

@Entity(tableName = FuelHistoryDatabase.FUEL_HISTORY_TABLE)
class RefillRecord(@PrimaryKey(autoGenerate = true) val id: Long,
                        @ColumnInfo val date: Long = 0,
                        @ColumnInfo val fuelVolume: Float = 0f,
                        @ColumnInfo val distance: Float = 0f)