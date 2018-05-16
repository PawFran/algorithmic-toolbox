package week3

import org.scalatest.FunSuite

class MoneyChangeTest extends FunSuite {

  test("0") {
    assert(MoneyChange.apply(2) == 2)
  }

  test("small number") {
    assert(MoneyChange.apply(2) == 2)
  }

  test("medium number") {
    assert(MoneyChange.apply(28) == 6)
  }

}
