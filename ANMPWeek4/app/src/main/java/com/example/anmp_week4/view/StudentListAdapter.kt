package com.example.anmp_week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.anmp_week4.R
import com.example.anmp_week4.databinding.StudentListItemBinding
import com.example.anmp_week4.model.Student
import com.example.anmp_week4.view.StudentListFragmentDirections.Companion.actionStudentDetail
import com.squareup.picasso.Picasso


class StudentListAdapter(val studentList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
, ButtonDetailClickListener{
    class StudentViewHolder(var view: StudentListItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.student_list_item, parent, false)
//        return StudentViewHolder(view)
        val view =  DataBindingUtil.inflate<StudentListItemBinding>(inflater,
            R.layout.student_list_item,parent,false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
       return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        holder.view.student= studentList[position]
        holder.view.listener=this
//        val txtID = holder.itemView.findViewById<TextView>(R.id.txtID);
//        val txtName = holder.itemView.findViewById<TextView>(R.id.txtName);
//        val btnDetail = holder.itemView.findViewById<Button>(R.id.btnDetail)
//        val imgPhoto = holder.itemView.findViewById<ImageView>(R.id.imgStudent)
//
//        val picasso = Picasso.Builder(holder.itemView.context)
//        picasso.listener { picasso, uri, exception ->
//            exception.printStackTrace()
//        }
//        picasso.build().load(studentList[position].photoUrl).into(imgPhoto)
//
//        txtID.text=studentList[position].id
//
//        var studentId=studentList[position].id.toString()
//        txtName.text=studentList[position].name
//
//        btnDetail.setOnClickListener{
//            Toast.makeText(
//                holder.itemView.context,
//                "Student Id $studentId",
//                Toast.LENGTH_SHORT
//            ).show()
//            val action = StudentListFragmentDirections.actionStudentDetail(studentId)
//            Navigation.findNavController(it).navigate(action)
//        }
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}