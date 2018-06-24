package week2

import org.scalatest.FunSuite

class GreatestCommonDivisorTest extends FunSuite {

  test("small numbers") {
    assert(GreatestCommonDivisor.compute(18, 35) == 1)
  }

  test("big numbers") {
    assert(GreatestCommonDivisor.compute(28851538, 1183019) == 17657)
  }

}
