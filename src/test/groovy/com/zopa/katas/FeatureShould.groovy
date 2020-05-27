package com.zopa.katas

import spock.lang.Specification
import spock.lang.Unroll

import static com.zopa.katas.Fruit.*

class FeatureShould extends Specification {

  def "calculate discount"() {
    expect:
    def fruits = [Apple, Cherry, Cherry, Banana, Banana, Banana]
    def result = FeatureKt.calculateDiscount(fruits)

    result == Cherry.discount + Banana.discount
  }

  @Unroll
  def "calculate iteration #fruits = #result"() {
    expect:

    FeatureKt.calculateSum(fruits) == result

    where:
    fruits                               | result
    [Manzana, Manzana, Manzana]          | 200
    [Manzana, Manzana, Manzana, Manzana] | 300
    [Apple, Apple, Apple, Apple]         | 300
    [Pomme, Pomme]                       | 50
    [Pomme, Pomme, Pomme]                | 150
    [Apple] * 5                          | 200
    [Apple] * 10                         | 400
  }
}
