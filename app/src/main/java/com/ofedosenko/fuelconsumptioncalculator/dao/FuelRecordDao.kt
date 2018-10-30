package com.ofedosenko.fuelconsumptioncalculator.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.ofedosenko.fuelconsumptioncalculator.database.FuelHistoryDatabase
import com.ofedosenko.fuelconsumptioncalculator.model.RefillRecord

@Dao
interface FuelRecordDao : BaseDao<RefillRecord>{

    @Query("SELECT * from ${FuelHistoryDatabase.FUEL_HISTORY_TABLE} ORDER BY 'date'")
    fun getAll(): LiveData<List<RefillRecord>>
}