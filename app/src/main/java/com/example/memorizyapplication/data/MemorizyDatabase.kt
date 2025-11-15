package com.example.memorizyapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// класс базы (синглтон)
@Database (entities = [Set::class], version = 1)
abstract class MemorizyDatabase : RoomDatabase(){
    abstract fun setDao(): SetDao   // предоставляем Dao доступ для операций над БД
    companion object {
        @Volatile   // гарантирует, что переменная всегда актуальна и одинакова для всех потоков
        private var Instance: MemorizyDatabase? = null  // ссылка на единственный экземпляр БД

        fun getDatabase(context: Context): MemorizyDatabase{
            return Instance ?: synchronized(this) { // либо существующая БД, либо делаем новую
                Room.databaseBuilder(
                    context = context,
                    klass = MemorizyDatabase::class.java,
                    name = "set_database"
                ).fallbackToDestructiveMigration(false) // если изменим БД, то приложение
                    .build()                                          // не запустистся, но зато таблицы
                    .also { Instance = it }                           // не будут удалены
            }
        }
    }
}