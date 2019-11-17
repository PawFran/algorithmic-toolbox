package week3

import org.scalatest.FunSuite

class CarFuelingTest extends FunSuite {
  test("distance is reachable in a few steps") {
    assert(
      CarFueling.compute(
        distance = 950, tankCapacity = 400,
        stops = Seq(200, 375, 550, 750)
      ) == 2
    )
  }

  test("distance is not reachable") {
    assert(
      CarFueling.compute(
        distance = 10, tankCapacity = 3,
        stops = Seq(1, 2, 5, 9)
      ) == -1
    )
  }
}
