package com.itacademy.myapplication

import android.app.Application
import androidx.room.Room
import com.itacademy.myapplication.database.AppDatabase

class Appl : Application() {
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries().build()
    }

    fun getDatabase(): AppDatabase? {
        return database
    }

    companion object{
        var instance: Appl? = null
    }
}