package com.example.anmp_week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.anmp_week4.model.Student
import org.json.JSONException

class DetailViewModel(private val requestQueue: RequestQueue): ViewModel() {
    val studentLD = MutableLiveData<Student>()

//    fun fetch() {
//        val student1 = Student(
//            "16055",
//            "Nonie",
//            "1998/03/28",
//            "5718444778",
//            "http://dummyimage.com/75x100.jpg/cc0000/ffffff"
//        )
//        studentLD.value = student1
//    }
fun fetch(id: String) {
    val url = "http://adv.jitusolution.com/student.php?id=$id"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {

                    val studentId = response.getString("id")
                    val studentName = response.getString("name")
                    val studentBirthdate = response.getString("birthdate")
                    val studentPhoneNumber = response.getString("phone_number")
                    val studentImageUrl = response.getString("image_url")

                    val student = Student(studentId, studentName, studentBirthdate, studentPhoneNumber, studentImageUrl)

                    studentLD.value = student
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { error ->
                error.printStackTrace()
            })

        // Menambahkan request ke antrian Volley
        requestQueue.add(jsonObjectRequest)
    }
}