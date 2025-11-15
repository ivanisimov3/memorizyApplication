package com.example.memorizyapplication.data

import kotlinx.coroutines.flow.Flow

// репозиторий - высокоуровневый способ работы с данными (по сравнению с Dao)
interface SetsRepository {
    suspend fun insertSet(set: Set)

    suspend fun deleteSet(set: Set)

    suspend fun updateSet(set: Set)

    fun getSetStream(id: Int): Flow<Set?>   // по конкретному id может быть null

    fun getAllSetsStream(): Flow<List<Set>> // даже если таблица пуста, то вернется пустой список
}