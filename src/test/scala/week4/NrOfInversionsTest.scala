package week4

import org.scalatest.FunSuite
import week4.NrOfInversions.apply

class NrOfInversionsTest extends FunSuite {

  test("short sequence with inversions") {
    assert(apply(Array(2, 3, 9, 2, 9)).nrOfInversions == 2)
  }

  test("short sequence without inversions") {
    assert(apply(Array(1, 2, 3, 4)).nrOfInversions == 0)
  }

  test("one element") {
    assert(apply(Array(1)).nrOfInversions == 0)
  }

}
