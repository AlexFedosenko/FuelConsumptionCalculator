package com.ofedosenko.fuelconsumptioncalculator.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    abstract fun insert(type: T): Long
}