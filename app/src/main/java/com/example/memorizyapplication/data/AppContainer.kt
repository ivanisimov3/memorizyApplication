package com.example.memorizyapplication.data

import android.content.Context

// описывает набор репозиториев
interface AppContainer {
    val setsRepository: SetsRepository
}

/*
В определенный момент времени при обращении к setsRepository (lazy) создается или используется
база данных (синглтон), которая в свою очередь создает Dao, который используется как база для
OfflineSetsRepository, выполняющего операции. Этот алгоритм выполняется только ОДИН раз при
инициализации setsRepository (все зависит от передаваемого контекста)
*/
class AppDataContainer(private val context: Context) : AppContainer {
    override val setsRepository: SetsRepository by lazy {
        OfflineSetsRepository(MemorizyDatabase.getDatabase(context).setDao())
    }
}