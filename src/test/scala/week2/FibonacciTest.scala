package week2

import org.scalatest.FunSuite

class FibonacciTest extends FunSuite {

  test("first") {
    Fibonacci.compute(0) == 0
  }

  test("second") {
    Fibonacci.compute(1) == 1
  }

  test("small number") {
    Fibonacci.compute(10) == 55
  }

  test("biggest allowed") {
    Fibonacci.compute(45) == 1134903170
  }

}
