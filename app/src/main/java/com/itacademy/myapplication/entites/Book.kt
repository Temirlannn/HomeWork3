package com.itacademy.myapplication.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(foreignKeys = arrayOf(ForeignKey(entity = Genre::class,
    parentColumns = arrayOf("idGenre"),
    childColumns = arrayOf("fnGenreId"))
))
data class Book(
    @PrimaryKey(autoGenerate = true) val idBook: Int?,
    @ColumnInfo(name = "bookName") var bookName: String?,
    @ColumnInfo(name = "author") var author: String?,
    @ColumnInfo(name = "publicationDate") var publicationDate: String?,
    @ColumnInfo(name = "pageAmount") var pageAmount: Int?,
    @ColumnInfo(name = "amount") var amount: Int?,
    @ColumnInfo(name = "place") var place: String?,
    @ColumnInfo(name = "fnGenreId") var fnGenreId: Int?
)

@Entity
data class Genre (
    @PrimaryKey(autoGenerate = true) val idGenre: Int?,
    @ColumnInfo(name = "name") var name: String
)
