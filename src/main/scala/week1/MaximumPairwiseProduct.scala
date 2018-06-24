package week1

/**
  * Input format. The first line contains an integer n. The next line contains
  * n non-negative integers a 1 , . . . , a n (separated by spaces).
  * Output format. The maximum pairwise product.
  * Constraints. 2 ≤ n ≤ 2 · 10 5 ; 0 ≤ a 1 , . . . , a n ≤ 2 · 10 5 .
  */
object MaximumPairwiseProduct extends App {
  val scanner = new java.util.Scanner(System.in)
  val inputSize = scanner.nextLine().map(_.toInt)
  val ints = scanner.nextLine().split(" ").map(BigInt(_))

  println(compute(ints))

  def compute(ints: Array[BigInt]): BigInt = {
    var biggest = BigInt(0)
    var secondBiggest = BigInt(0)
    ints.foreach { number =>
      if (number > biggest) {
        secondBiggest = biggest
        biggest = number
      } else if (number > secondBiggest) {
        secondBiggest = number
      }
    }
    biggest * secondBiggest
  }
}
