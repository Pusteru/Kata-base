package com.zopa.katas

import com.zopa.katas.Fruit.*

enum class Fruit(val price: Int, val discount: Int) {
  Apple(100, 0),
  Cherry(70, 30),
  Banana(130, 130),
  Empty(0, 0)
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
  val fruit = when (line) {
    "Apple",
    "Manzana",
    "Pomme" -> Apple
    "Cherry" -> Cherry
    "Banana" -> Banana
    else -> Empty
  }

  return listOf(fruit)
}

fun calculateSum(fruits: List<Fruit>): Int {
  return fruits.map { it.price }.sum() - calculateDiscount(fruits)
}

fun calculateDiscount(fruits: List<Fruit>): Int =
  Fruit.values()
    .map { fruit -> fruit to fruits.count { it == fruit } }
    .map { it.first.discount * (it.second / 2) }
    .sum()


