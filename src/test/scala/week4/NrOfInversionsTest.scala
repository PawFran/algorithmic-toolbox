package week4

import org.scalatest.FunSuite

class NrOfInversionsTest extends FunSuite {

  test("short sequence with inversions") {
    assert(NrOfInversions.compute(Array(2, 3, 9, 2, 9)).nrOfInversions == 2)
  }

  test("short sequence without inversions") {
    assert(NrOfInversions.compute(Array(1, 2, 3, 4)).nrOfInversions == 0)
  }

  test("one element") {
    assert(NrOfInversions.compute(Array(1)).nrOfInversions == 0)
  }

}
