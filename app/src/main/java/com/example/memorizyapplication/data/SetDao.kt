package com.example.memorizyapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Data Access Object - все операции с базой данных (низкоуровнево)
@Dao
interface SetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // игнорировать добавление нового набора
    suspend fun insert(set: Set)

    @Delete
    suspend fun delete(set: Set)

    @Update
    suspend fun update(set: Set)

    @Query("SELECT * from sets WHERE id = :id")
    fun getSet(id: Int): Flow<Set>

    @Query("SELECT * from sets ORDER BY id")
    fun getAllSets(): Flow<List<Set>>
}