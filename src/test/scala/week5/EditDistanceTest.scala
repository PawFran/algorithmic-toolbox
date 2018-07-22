package week5

import org.scalatest.FunSuite

class EditDistanceTest extends FunSuite {

  test("same strings") {
    assert(EditDistance.compute("ab", "ab") == 0)
  }

  test("different strings") {
    assert(EditDistance.compute("short", "ports") == 3)
  }

  test("slightly longer different strings") {
    assert(EditDistance.compute("editing", "distance") == 5)
  }

}
