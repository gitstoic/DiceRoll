package com.example.diceroll

fun main() {
    val car1 = Car("black","Benz")
    println("My ${car1.color} car is a ${car1.name} and likely costs ${car1.cost()} and has ${car1.numberOfDoors} doors")

    val car2 = Car("wine","Peugeot")
    println("My ${car2.color} car is a ${car2.name} and likely costs ${car2.cost()} and runs on ${car1.fuel}")
}

open class Car(var color : String, var name : String) {
    val numberOfDoors = 4
    val fuel = "electricity"


    fun cost() : String {
        return arrayOf("$50000", "$70000", "$90000", "$57000").random()
    }
}
//creating ToyVehicle as an inheritance of the properties "color" and "name" of the superclass "Car"
class ToyVehicle : Car("Red",  "Ambulance"){
    var material = "plastic"
    fun spin(){}

}
