package week1

object MaximumPairwiseProduct extends App {
  val scanner = new java.util.Scanner(System.in)
  val inputSize = scanner.nextLine().map(_.toInt)
  val ints = scanner.nextLine().split(" ").map(BigInt(_))

  println(apply(ints))

  def apply(ints: Array[BigInt]): BigInt = {
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
