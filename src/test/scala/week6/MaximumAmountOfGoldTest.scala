package week6

import org.scalatest.FunSuite

class MaximumAmountOfGoldTest extends FunSuite {

  test("some items fit") {
    assert(MaximumAmountOfGold.compute(Array(1, 4, 8), 10) == 9)
  }

  test("all items fit") {
    assert(MaximumAmountOfGold.compute(Array(1, 4, 2), 10) == 7)
  }

  test("no items fit") {
    assert(MaximumAmountOfGold.compute(Array(2, 4, 8), 1) == 0)
  }
}
