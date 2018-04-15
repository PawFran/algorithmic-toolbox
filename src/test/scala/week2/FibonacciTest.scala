package week2

import org.scalatest.FunSuite

class FibonacciTest extends FunSuite {

  test("first") {
    Fibonacci.apply(0) == 0
  }

  test("second") {
    Fibonacci.apply(1) == 1
  }

  test("small number") {
    Fibonacci.apply(10) == 55
  }

  test("biggest allowed") {
    Fibonacci.apply(45) == 1134903170
  }

}
