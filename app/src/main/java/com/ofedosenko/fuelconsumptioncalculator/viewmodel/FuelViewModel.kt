package com.ofedosenko.fuelconsumptioncalculator.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ofedosenko.fuelconsumptioncalculator.database.FuelHistoryDatabase
import com.ofedosenko.fuelconsumptioncalculator.model.RefillRecord
import org.jetbrains.anko.doAsync

class FuelViewModel(application: Application) : AndroidViewModel(application) {

    private val db: FuelHistoryDatabase? = FuelHistoryDatabase.getInstance(application)

    private lateinit var fuelData: LiveData<List<RefillRecord>>

    fun getFuelHistory(): LiveData<List<RefillRecord>> {
        if (!::fuelData.isInitialized) {
            fuelData = loadFuelData()
        }
        return fuelData
    }

    private fun loadFuelData() : LiveData<List<RefillRecord>> {
        // Do an asynchronous operation to fetch data
        return db?.fuelRecordDao()?.getAll()!!
    }

    fun insertRefillInfo(record: RefillRecord) {
        doAsync {
            db?.fuelRecordDao()?.insert(record)
        }
    }
}