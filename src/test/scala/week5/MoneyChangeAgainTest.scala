package week5

import org.scalatest.FunSuite

class MoneyChangeAgainTest extends FunSuite {

  test("small number") {
    assert(MoneyChangeAgain.compute(2) == 2)
  }

  test("medium number") {
    assert(MoneyChangeAgain.compute(34) == 9)
  }

}
