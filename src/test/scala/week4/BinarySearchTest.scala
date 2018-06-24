package week4

import org.scalatest.FunSuite

class BinarySearchTest extends FunSuite {

  test("desired element in the middle") {
    assert(BinarySearch.compute(Array(1, 5, 8, 12, 13), 8) == 2)
  }

  test("desired element present") {
    assert(BinarySearch.compute(Array(1, 5, 8, 12, 13), 1) == 0)
  }

  test("desired element absent") {
    assert(BinarySearch.compute(Array(1, 5, 8, 12, 13), 23) == -1)
  }
}
