package com.example.todoapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.R
import com.example.todoapp.viewmodel.DetailTodoViewModel


class EditTodoFragment : Fragment() {
    private lateinit var viewModel: DetailTodoViewModel
    private lateinit var txtJudulTodo: TextView
    private lateinit var txtTitle: EditText
    private lateinit var txtNotes: EditText
    private lateinit var btnAdd: Button
    private lateinit var radioGroupPriority: RadioGroup
    private lateinit var radioHigh: RadioButton
    private lateinit var radioMedium: RadioButton
    private lateinit var radioLow: RadioButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)
        txtJudulTodo = view.findViewById(R.id.txtJudulTodo)
        txtTitle = view.findViewById(R.id.txtTitle)
        txtNotes = view.findViewById(R.id.txtNotes)
        btnAdd = view.findViewById(R.id.btnAdd)
        radioGroupPriority = view.findViewById(R.id.radioGroupPriority)
        radioHigh = view.findViewById(R.id.radioHigh)
        radioMedium = view.findViewById(R.id.radioMedium)
        radioLow = view.findViewById(R.id.radioLow)

        txtJudulTodo.text = "Edit Todo"

        val uuid = EditTodoFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)
        observeViewModel()


    }
    fun observeViewModel() {
        viewModel.todoLD.observe(viewLifecycleOwner, { todo ->
            txtTitle.setText(todo.title)
            txtNotes.setText(todo.notes)
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_todo, container, false)
    }


}