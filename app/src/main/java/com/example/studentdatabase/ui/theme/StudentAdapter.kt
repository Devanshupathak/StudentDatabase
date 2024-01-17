package com.example.studentdatabase.ui.theme

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.studentdatabase.DataHelper
import com.example.studentdatabase.R
import com.example.studentdatabase.Student

class StudentAdapter (private val context: Context,private var
studentList : ArrayList<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).
                inflate(R.layout.item_student,parent,false))
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.onBind(studentList[position])
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun onBind(student:Student){
            itemView.tv_nim.text = student.nim.toString()
            itemView.tv_name.text= student.name
            itemView.tv_faculty.text = student.faculty
            if(student.gender =="Male"){
                itemView.iv_student.setImageResource(R.drawable.maleprofile)
            }
            else{
                itemView.iv_student.setImageResource(R.drawable.femaleprofile)
            }
            itemView.setOnClickListener{
                val alertDialogBuilder = AlertDialog.Builder(itemView.context)
                alertDialogBuilder.setTitle("Confirm")
                    .setMessage("Are you sure to delete?")
                    .setCancelable(true)
                    .setPositiveButton("No"){dialog,which->
                        Toast.makeText(itemView.context,"cancle Delete",Toast.LENGTH_SHORT)
                    }
                    .setNegativeButton("Yes"){dialog,which->
                        val data = DataHelper
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

}