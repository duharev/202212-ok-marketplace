package ru.otus.otuskotlin.marketplace.m1l2

//Одно и то же:
//1:
fun f1(): Int {
    return 1 + 2
}
//2:
fun f2(): Int = 1 + 2
//3:
fun f3() = 1 + 2

//----------------Переменное число параметров
fun f4(vararg s: String): Int {
    return s.size
}
//----------------Вараг может быть на каком угодно месте, но остальные параметры нужно передавать поименно
fun f5(vararg s: String, b: Int): Int {
    return s.size
}

fun main(args: Array<String>) {

    println(f4("1", "2", "3"))
    println(f4("1", "2", "3", "4"))

//    println(f5("1", "2", "3", "4", 6)) // нельзя
    println(f5("1", "2", "3", "4", b = 6)) // нужно так

}