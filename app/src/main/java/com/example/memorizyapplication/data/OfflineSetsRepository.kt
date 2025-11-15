package com.example.memorizyapplication.data

import kotlinx.coroutines.flow.Flow

// реализация репозитория для работы с ОФЛАЙН данными
class OfflineSetsRepository (private val setDao: SetDao) : SetsRepository {
    override suspend fun insertSet(set: Set) = setDao.insert(set)

    override suspend fun updateSet(set: Set) = setDao.update(set)

    override suspend fun deleteSet(set: Set) = setDao.delete(set)

    override fun getSetStream(id: Int): Flow<Set?> = setDao.getSet(id)

    override fun getAllSetsStream(): Flow<List<Set>> = setDao.getAllSets()
}