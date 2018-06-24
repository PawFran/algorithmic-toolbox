package week2

import org.scalatest.FunSuite

class LeastCommonMultipleTest extends FunSuite {

  test("small numbers") {
    assert(LeastCommonMultiple.compute(6, 8) == 24)
  }

  test("big numbers") {
    assert(LeastCommonMultiple.compute(28851538, 1183019) == 1933053046)
  }

}
