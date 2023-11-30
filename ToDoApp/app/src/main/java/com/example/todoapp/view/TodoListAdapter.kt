package com.example.todoapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.databinding.TodoItemLayoutBinding
import com.example.todoapp.model.Todo
import com.example.todoapp.viewmodel.ListTodoViewModel

class TodoListAdapter(val todoList:ArrayList<Todo>, val adapterOnClick : (Todo) -> Unit)
    : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>(),
    TodoCheckedChangeListener, TodoEditClick {
    class TodoViewHolder(var view: TodoItemLayoutBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.todo_item_layout, parent, false)
        val view =  DataBindingUtil.inflate<TodoItemLayoutBinding>(inflater,
            R.layout.todo_item_layout,parent,false)

        return TodoViewHolder(view)

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int)
    {
        holder.view.todo= todoList[position]
        holder.view.listener = this
        holder.view.editListener=this

//
//        var checktask = holder.view.findViewById<CheckBox>(R.id.checkTask)
//        checktask.text = todoList[position].title+" "+todoList[position].priority
//        var imgEdit = holder.view.findViewById<ImageButton>(R.id.imgEdit)
//
//        checktask.setOnCheckedChangeListener { compoundButton, isChecked ->
//            adapterOnClick(todoList[position])
////            viewModel.updateStatus(todoList[position].uuid)
//
//        }
//
//        imgEdit.setOnClickListener {
//            val action =
//                TodoListFragmentDirections.actionEditToDo(todoList[position].uuid)
//
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        checktask.setOnCheckedChangeListener { compoundButton, isChecked ->
//            if(isChecked == true) {
//                adapterOnClick(todoList[position])
//            }
//        }

    }
    fun updateTodoList(newTodoList: List<Todo>) {
        todoList.clear()
        todoList.addAll(newTodoList)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return todoList.size

    }

    override fun onCheckedChanged(cb: CompoundButton, isChecked: Boolean, obj: Todo) {
        if(isChecked == true) {
                adapterOnClick(obj)
            }
    }

    override fun onTodoEditClick(v: View) {
        val action =
                TodoListFragmentDirections.actionEditToDo(v.tag.toString().toInt())

            Navigation.findNavController(v).navigate(action)
    }
}
