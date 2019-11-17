package week3

import org.scalatest.FunSuite

class LootMaximumValueTest extends FunSuite {

  test("three items, two fitting completely") {
    val items = IndexedSeq(Item(120, 30), Item(60, 20), Item(100, 50))
    assert(
      LootMaximumValue.compute(items, capacity=50) == 180.0
    )
  }

  test("only one item and above weight") {
    val items = IndexedSeq(Item(500, 30))
    assert(
      (LootMaximumValue.compute(items, capacity=10) * 1000).toInt == 166666
    )
  }

}
