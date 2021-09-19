package com.itis.a1semitis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student= ClassStudent("Oleg",20,101)
        student.Study()
        println("Kek ${student.kek}")

        val teacher=ClassTeacher("Arslanov",1,102)
        teacher.Chilling()
        println("Lol ${teacher.lol}")
    }
}