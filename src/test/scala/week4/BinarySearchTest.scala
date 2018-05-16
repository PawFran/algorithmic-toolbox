package week4

import org.scalatest.FunSuite

import BinarySearch.apply

class BinarySearchTest extends FunSuite {

  test("desired element in the middle") {
    assert(apply(Array(1, 5, 8, 12, 13), 8) == 2)
  }

  test("desired element present") {
    assert(apply(Array(1, 5, 8, 12, 13), 1) == 0)
  }

  test(" desired element absent") {
    assert(apply(Array(1, 5, 8, 12, 13), 23) == -1)
  }
}
