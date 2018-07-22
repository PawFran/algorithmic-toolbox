package week5

import org.scalatest.FunSuite

class PrimitiveCalculatorTest extends FunSuite {

  test("smallest possible number") {
    assert(PrimitiveCalculator.compute(1) == List(1))
  }

  test("small number") {
    assert(PrimitiveCalculator.compute(5) == List(1, 2, 4, 5))
  }

  test("bigger number") {
    assert(PrimitiveCalculator.compute(96234) == List(1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234))
  }

}
