package week3

import org.scalatest.FunSuite

class MoneyChangeTest extends FunSuite {

  test("0") {
    assert(MoneyChange.compute(2) == 2)
  }

  test("small number") {
    assert(MoneyChange.compute(2) == 2)
  }

  test("medium number") {
    assert(MoneyChange.compute(28) == 6)
  }

}
