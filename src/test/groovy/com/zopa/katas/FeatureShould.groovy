package com.zopa.katas

import spock.lang.Specification

import static com.zopa.katas.Fruit.*

class FeatureShould extends Specification {

  def "calculate discount"() {
    expect:
    def fruits = [Apple, Cherry, Cherry, Banana, Banana, Banana]
    def result = FeatureKt.calculateDiscount(fruits)

    result == Cherry.discount + Banana.discount
  }

  def "calculate sum"() {
    expect:
    def fruits = [Apple, Cherry, Cherry, Banana, Banana, Banana]
    def discount = Cherry.discount + Banana.discount
    def result = FeatureKt.calculateSum(fruits)

    result == Apple.price + Cherry.price * 2 + Banana.price * 3 - discount
  }
}
