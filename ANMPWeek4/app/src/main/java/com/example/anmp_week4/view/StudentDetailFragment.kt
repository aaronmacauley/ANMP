package com.example.anmp_week4.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.anmp_week4.R
import com.example.anmp_week4.viewmodel.DetailViewModel
import com.google.android.material.textfield.TextInputEditText

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application))
                .get(DetailViewModel::class.java)

        val txtID = view.findViewById<TextInputEditText>(R.id.txtID)
        val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
        val txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
        val txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)

        if (arguments != null) {
            val studentId =
                StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
            viewModel.fetch(studentId)
        }

        viewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
            txtID.setText(student.id)
            txtName.setText(student.name)
            txtBod.setText(student.dob)
            txtPhone.setText(student.phone)
        })
    }
}

