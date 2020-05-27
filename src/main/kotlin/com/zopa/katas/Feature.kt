package com.zopa.katas


val elements: MutableList<Fruit> = mutableListOf()

enum class Fruit(val price: Int, val discount: Int) {
  Apple(100, 0),
  Cherry(70, 20),
  Banana(130, 0)
}

fun main() {
  while (true) {
    val result = readLine()!!
    val fruit = try {
      Fruit.valueOf(result)
    } catch (e: Exception) {
      println(calculateSum(elements))
      continue
    }
    elements.add(fruit)
    println(calculateSum(elements))
  }
}

fun calculateSum(elements: List<Fruit>): Int {
  val sum = elements.map { it.price }.sum()
  val totalDiscount = Fruit.values()
    .map { fruits ->
      fruits to elements.count { it == fruits }
    }
    .map {
      it.first.discount * (it.second / 2)
    }
    .sum()
  return sum - totalDiscount
}
