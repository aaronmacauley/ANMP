package com.example.anmp_week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.anmp_week4.R
import com.example.anmp_week4.model.Student
import com.example.anmp_week4.viewmodel.DetailViewModel
import com.example.anmp_week4.viewmodel.ListViewModel
import com.example.anmp_week4.viewmodel.NarutosViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
//    private val studentDetailAdapter = StudentDetailAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        val txtID = view.findViewById<EditText>(R.id.txtID)
        val txtName = view.findViewById<EditText>(R.id.txtName)
        val txtBod = view.findViewById<EditText>(R.id.txtBod)
        val txtPhone = view.findViewById<EditText>(R.id.txtPhone)

        viewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
            txtID.setText(student.id)
            txtName.setText(student.name)
            txtBod.setText(student.dob)
            txtPhone.setText(student.phone)
        })
    }

}