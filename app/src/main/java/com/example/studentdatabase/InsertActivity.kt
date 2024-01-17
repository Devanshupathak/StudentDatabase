package com.example.studentdatabase

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class InsertActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        val dataHelper = DataHelper(this)
        val b_insert = findViewById<Button>(R.id.bins)
        val et_nim = findViewById<EditText>(R.id.et_nim)
        val et_name = findViewById<EditText>(R.id.et_name)
        val et_faculty = findViewById<EditText>(R.id.et_faculty)
        val rg_gender = findViewById<RadioGroup>(R.id.rg_gender)
        b_insert.setOnClickListener{
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Confirm")
                .setMessage("Are you sure to insert it?")
                .setCancelable(true)
                .setPositiveButton("No"){dialog,which->}
                .setNegativeButton("Yes"){dialog,which->
                    val nim=Integer.parseInt(et_nim.text.toString())
                    val name = et_name.text.toString()
                    val faculty = et_faculty.text.toString()
                    val gender = findViewById<RadioButton>(rg_gender.checkedRadioButtonId)
                    dataHelper.addStudent(Student(nim,name,gender.text.toString(),faculty))
                    et_name.setText("")
                    et_nim.setText("")
                    et_faculty.setText("")
                    finish()
                }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}