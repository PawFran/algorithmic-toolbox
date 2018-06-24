package week5

import org.scalatest.FunSuite

class PrimitiveCalculatorTest extends FunSuite {

  test("smallest possible number") {
    PrimitiveCalculator.compute(1) sameElements Array(0)
  }

  test("small number") {
    PrimitiveCalculator.compute(5) sameElements Array(1, 2, 4, 5)
  }

  test("bigger number") {
    PrimitiveCalculator.compute(96234) sameElements Array(1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234)
  }

}
