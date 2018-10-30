package com.ofedosenko.fuelconsumptioncalculator.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

/**
 * Just separate common operations which could be used by other high-level Dao
 */
interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    fun insert(type: T): Long
}