package com.zopa.katas


fun main() {
  var sum = 0
  while (true) {
    val result = readLine()!!
    sum += toSum(result)
    println(sum)
  }
}
fun toSum(fruit: String): Int {
  return when (fruit) {
    "Apple" -> 100
    "Cherry" -> 70
    "Banana" -> 130
    else -> 0
  }
}

