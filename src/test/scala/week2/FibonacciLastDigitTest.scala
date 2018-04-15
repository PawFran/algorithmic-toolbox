package week2

import org.scalatest.FunSuite

class FibonacciLastDigitTest extends FunSuite {

  test("first") {
    assert(FibonacciLastDigit.apply(0) == 0)
  }

  test("second") {
    assert(FibonacciLastDigit.apply(1) == 1)
  }

  test("small number") {
    assert(FibonacciLastDigit.apply(3) == 2)
  }

  test("medium number") {
    assert(FibonacciLastDigit.apply(331) == 9)
  }

  test("big number") {
    assert(FibonacciLastDigit.apply(327305) == 5)
  }

}
