package week4

import org.scalatest.FunSuite

class MajorityElementTest extends FunSuite {

  test("sequence with majority element") {
    assert(MajorityElement.compute(Seq(2, 3, 9, 2, 2)) == 2)
  }

  test("sequence without majority element") {
    assert(MajorityElement.compute(Seq(1, 2, 3, 4)) == -1)
  }

  test("sequence without majority element when one element appears half times") {
    assert(MajorityElement.compute(Seq(1, 2, 3, 1)) == -1)
  }

  test("five elements, two pairs and one odd out") {
    assert(MajorityElement.compute(Seq(1, 1, 0, 2, 2)) == -1)
  }

  test("four elements, two pairs") {
    assert(MajorityElement.compute(Seq(1, 1, 2, 2)) == -1)
  }

  test("five elements, two occurrences in the same half") {
    assert(MajorityElement.compute(Seq(0, 3, 9, 2, 2)) == -1)
  }

}
