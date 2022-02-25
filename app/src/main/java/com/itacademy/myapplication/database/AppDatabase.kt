package com.itacademy.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itacademy.myapplication.dao.BookDao
import com.itacademy.myapplication.dao.GenreDao
import com.itacademy.myapplication.entites.Book
import com.itacademy.myapplication.entites.Genre


@Database(entities = [Book::class, Genre::class], exportSchema = false, version = 9 )
abstract class AppDatabase : RoomDatabase(){
    abstract fun bookDao(): BookDao
    abstract fun genreDao(): GenreDao

}