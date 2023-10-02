 package com.example.anmp_week4.model

 import com.google.gson.annotations.SerializedName

 data class Student(
     val id:String?,
     @SerializedName("student_name")
     val name:String?,
     @SerializedName("birth_of_date")
     val dob:String?,
     val phone:String?,
     @SerializedName("photo_url")
     val photoUrl:String
 )

 data class Naruto(
     val id: Int?,
     val name: String?,
     val age: Int?,
     val village: String?,
     val affiliation: String?,
     val jutsu: List<String>?,
     val rank: String?,
     val team: String?,
     val friends: List<String>?,
     val enemies: List<String>?,
     val status: String?
 )


