package week2

import org.scalatest.FunSuite

class FibonacciLastDigitTest extends FunSuite {

  test("first") {
    assert(FibonacciLastDigit.compute(0) == 0)
  }

  test("second") {
    assert(FibonacciLastDigit.compute(1) == 1)
  }

  test("small number") {
    assert(FibonacciLastDigit.compute(3) == 2)
  }

  test("medium number") {
    assert(FibonacciLastDigit.compute(331) == 9)
  }

  test("big number") {
    assert(FibonacciLastDigit.compute(327305) == 5)
  }

}
