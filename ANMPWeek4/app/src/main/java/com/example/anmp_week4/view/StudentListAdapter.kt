package com.example.anmp_week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.anmp_week4.R
import com.example.anmp_week4.model.Student
import com.example.anmp_week4.view.StudentListFragmentDirections.Companion.ActionStudentDetail
import com.squareup.picasso.Picasso


class StudentListAdapter(val studentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
    class StudentViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
       return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val txtID = holder.itemView.findViewById<TextView>(R.id.txtID);
        val txtName = holder.itemView.findViewById<TextView>(R.id.txtName);
        val btnDetail = holder.itemView.findViewById<Button>(R.id.btnDetail)
        val imgPhoto = holder.itemView.findViewById<ImageView>(R.id.imgStudent)

        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(studentList[position].photoUrl).into(imgPhoto)

        txtID.text=studentList[position].id
        var idStudent=studentList[position].id

        var studentId = idStudent.toString()

        txtName.text=studentList[position].name



        btnDetail.setOnClickListener{
            Toast.makeText(
                holder.itemView.context,
                "Student Id $studentId",
                Toast.LENGTH_SHORT
            ).show()
            val action = StudentListFragmentDirections.ActionStudentDetail(studentId)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}