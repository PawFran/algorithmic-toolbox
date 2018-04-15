package week1

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import org.scalatest.FunSuite

class MaximumPairwiseProductTest extends FunSuite {

  test("small input") {
    assert(MaximumPairwiseProduct.apply(Array(1, 2, 3).map(BigInt(_))) == 6)
  }

  test("slightly longer list") {
    assert(MaximumPairwiseProduct.apply(Array(7, 5, 14, 2, 8, 8, 10, 1, 2, 3).map(BigInt(_))) == 140)
  }

}

object MaximumPairwiseProductSpecification extends Properties("MaximumPairwiseProduct") {

  property("at least two integers, all non negative") = forAll { (a: Array[BigInt]) =>
    val atLeastTwoNonNegative =
      if (a.length < 2) Array(BigInt(0), BigInt(0))
      else a.map(_ max 0).sorted

    MaximumPairwiseProduct.apply(atLeastTwoNonNegative) == atLeastTwoNonNegative.sorted.takeRight(2).product
  }

}