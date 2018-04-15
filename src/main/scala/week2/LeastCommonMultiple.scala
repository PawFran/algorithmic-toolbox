package week2

import java.util.Scanner

/**
  * Task. Given two integers a and b, find their least common multiple.
  * Input Format. The two integers a and b are given in the same line separated by space.
  * Constraints. 1 ≤ a, b ≤ 2 · 10 9 .
  * Output Format. Output the least common multiple of a and b.
  */
object LeastCommonMultiple extends App {
  private val scanner = new Scanner(System.in)
  private val numbers = scanner.nextLine().split(" ").map(_.toInt)

  println(apply(numbers.head, numbers.last))

  def apply(a: Int, b: Int): BigInt = {
    (BigInt(a) * BigInt(b)) / gcd(a, b)
  }

  private def gcd(a: Int, b: Int): Int = {
    val sorted = List(a, b).sorted
    val first = sorted.last
    val second = sorted.head

    println(s"first: $first, second: $second")

    if (second == 0) first
    else gcd(second, first % second)
  }
}
