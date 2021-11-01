package com.itis.a1semitis

object PersonRepository {

    val people = arrayListOf(
        Person(
            1, R.drawable.damir, "Дамир", "Студент","Живет в Деревне Универсиады"
        ),
        Person(
            2, R.drawable.nina, "Нина", "Организатор","Подруга Виктории"
        ),
        Person(
            3, R.drawable.oleg, "Олег", "Куратор","Это я"),
        Person(
            4, R.drawable.olesya, "Олеся", "Староста","Моя староста"
        ),
        Person(
            5, R.drawable.radmir, "Радмир", "Староста блока",
            "Мой староста Блока"
        ),
        Person(
            6, R.drawable.ramazan, "Рамазан", "Актер",
            "Очень круто поет"
        ),
        Person(
            7, R.drawable.rasim, "Расим", "Староста",
            "Также живет в Деревне Универсиады"
        ),
        Person(
            8, R.drawable.salavat, "Салават", "Друг",
            "Мой лучший друг"
        ),
        Person(
            9, R.drawable.stepan, "Степан", "Степа",
            "Мой друг"
        ),
        Person(
            10, R.drawable.viktoria, "Виктория", "Куратор",
            "Живет на Пушке около Двойки"
        ),

    )

    fun PersonId(id: Int): Person {
        return this.people[id-1]
    }
}