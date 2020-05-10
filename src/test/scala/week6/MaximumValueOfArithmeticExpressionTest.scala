package week6

import org.scalatest.FunSuite

class MaximumValueOfArithmeticExpressionTest extends FunSuite {

  test("two-digit expression: 1 + 5") {
    assert(MaximumValueOfArithmeticExpression.compute(Array(1, 5), Array("+")) == 6)
  }

  test("two-digit expression: 5 - 8") {
    assert(MaximumValueOfArithmeticExpression.compute(Array(5, 8), Array("-")) == -3)
  }

  test("six-digit expression: 5-8+7*4-8+9") {
    assert(MaximumValueOfArithmeticExpression.compute(Array(5, 8, 7, 4, 8, 9), Array("-", "+", "*", "-", "+")) == 200)
  }

}
