package com.zopa.katas

import com.zopa.katas.Fruit.*

enum class Fruit(val price: Int, val discount: Int, val times: Int) {
  Apple(100, 100, 4),
  Manzana(100, 100, 3),
  Pomme(100, 150, 2),
  Cherry(70, 30, 2),
  Banana(130, 130, 2),
  Empty(0, 0, 1)
}

fun main() {
  val listOfFruits = mutableListOf<Fruit>()
  while (true) {
    val result = readLine()!!
    listOfFruits.addAll(parseLine(result))
    println(calculateSum(listOfFruits))
  }
}

fun parseLine(line: String): List<Fruit> {
  return line.split(",")
    .map {
      when (it) {
        "Apple" -> Apple
        "Manzana" -> Manzana
        "Pomme" -> Pomme
        "Cherry" -> Cherry
        "Banana" -> Banana
        else -> Empty
      }
    }.toList()
}

fun calculateSum(fruits: List<Fruit>): Int {
  return fruits.map { it.price }.sum() -
      calculateDiscount(fruits) -
      calculateItemDiscount(fruits)
}

fun calculateDiscount(fruits: List<Fruit>): Int =
  values()
    .map { fruit -> fruit to fruits.count { it == fruit } }
    .map { it.first.discount * (it.second / it.first.times) }
    .sum()


fun calculateItemDiscount(fruits: List<Fruit>): Int = fruits.size / 5 * 200


