package week4

import org.scalatest.FunSuite

class MajorityElementTest extends FunSuite {

  test("sequence with majority element") {
    assert(MajorityElement.compute(Array(2, 3, 9, 2, 2)) == 2)
  }

  test("sequence without majority element") {
    assert(MajorityElement.compute(Array(1, 2, 3, 4)) == -1)
  }

  test("sequence without majority element when one element appears half times") {
    assert(MajorityElement.compute(Array(1, 2, 3, 1)) == -1)
  }

}
