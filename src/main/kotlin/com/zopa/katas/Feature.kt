package com.zopa.katas

import com.zopa.katas.Fruit.*
import sun.invoke.empty.Empty


enum class Fruit(val price: Int, val discount: Int) {
  Apple(100, 0),
  Cherry(70, 20),
  Banana(130, 0),
  Empty(0, 0)
}

fun main() {
  while (true) {
    val result = readLine()!!
    println(calculateSum(parseLine(result)))
  }
}

fun parseLine(line: String): List<Fruit> {
  return line.split(",")
    .map {
      when (it) {
        "Apple" -> Apple
        "Cherry" -> Cherry
        "Banana" -> Banana
        else -> Empty
      }
    }
    .toList()
}

fun calculateSum(elements: List<Fruit>): Int {
  val sum = elements.map { it.price }.sum()
  val totalDiscount = values()
    .map { fruits ->
      fruits to elements.count { it == fruits }
    }
    .map {
      it.first.discount * (it.second / 2)
    }
    .sum()
  return sum - totalDiscount
}
