package week5

import org.scalatest.FunSuite
import week5.MoneyChangeAgain.apply

class MoneyChangeAgainTest extends FunSuite {

  test("small number") {
    assert(apply(2) == 2)
  }

  test("medium number") {
    assert(apply(34) == 9)
  }

}
