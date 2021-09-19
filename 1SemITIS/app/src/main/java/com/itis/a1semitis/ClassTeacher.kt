package com.itis.a1semitis

class ClassTeacher(
    name: String,
    personID: Int,
    var lol: Int,
):Person(name,personID),InterfaceChilling{
    override fun Chilling() {
        println("Chilling...")
    }
}