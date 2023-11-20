package com.example.todoapp.viewmodel

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.todoapp.model.Todo
import com.example.todoapp.model.TodoDatabase
import com.example.todoapp.util.buildDb
import com.example.todoapp.view.TodoListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class ListTodoViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val todoLD = MutableLiveData<List<Todo>>()
    val todoLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun refresh() {
        loadingLD.value = true
        todoLoadErrorLD.value = false
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                TodoDatabase::class.java, "newtododb").build()

            val allTodos = db.todoDao().selectAllTodo()
            todoLD.postValue(allTodos)
        }
    }

    fun clearTask(todo: Todo) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                TodoDatabase::class.java, "newtododb").build()
            db.todoDao().deleteTodo(todo)

            val allTodos = db.todoDao().selectAllTodo()
            todoLD.postValue(allTodos)
        }
    }

//    fun updateStatus(uuid:Int){
//        launch {
////            val db = util.buildDb(getApplication())
//            val db= buildDb(getApplication())
//            db.todoDao().updateStatus(uuid)
//        }
//    }


}
