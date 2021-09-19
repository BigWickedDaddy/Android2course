package com.itis.a1semitis

class ClassStudent(
    name: String,
    personID: Int,
    var kek:Int,
):Person(name,personID),InterfaceStudy{
    override fun Study() {
            println("Studying")
    }

}