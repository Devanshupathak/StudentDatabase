package com.example.studentdatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataHelper (private val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private val DATABASE_NAME = "biodatadiri.db"
        private val DATABASE_VERSION = 3
        val TABLE_NAME = "STUDENT"
        val KEY_NIM = "nim"
        val KEY_NAME = "name"
        val KEY_GENDER = "gender"
        val KEY_FAC = "faculty"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE" +
                TABLE_NAME + "("
                + "NIM" + "INTEGER PRIMARY KEY," +
                "NAME" + "TEXT," +
                "GENDER" + "TEXT," +
                "FACULTY" + "TEXT)")
        db.execSQL(CREATE_PRODUCTS_TABLE)
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
        TODO("Not yet implemented")
    }

    fun addStudent(student: Student): Boolean {
        var db = this.writableDatabase
        var values = ContentValues()
        values.put(KEY_NIM, student.nim)
        values.put(KEY_NAME, student.name)
        values.put(KEY_GENDER, student.gender)
        values.put(KEY_FAC, student.faculty)
        val success = db.insert(TABLE_NAME, null, values)
        db.close()
        if (success.toInt() == -1) {
            Toast.makeText(context, "Success Insert", Toast.LENGTH_SHORT).show()
            return true
        }
    }
    
}


