package week2

import org.scalatest.FunSuite

class LeastCommonMultipleTest extends FunSuite {

  test("small numbers") {
    assert(LeastCommonMultiple.apply(6, 8) == 24)
  }

  test("big numbers") {
    assert(LeastCommonMultiple.apply(28851538, 1183019) == 1933053046)
  }

}
