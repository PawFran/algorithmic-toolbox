package week2

import java.util.Scanner

/**
  * Task. Given two integers a and b, find their greatest common divisor.
  * Input Format. The two integers a, b are given in the same line separated by space.
  * Constraints. 1 ≤ a, b ≤ 2 · 10 9 .
  * Output Format. Output GCD(a, b).
  */
object GreatestCommonDivisor extends  App {
  private val scanner = new Scanner(System.in)
  private val numbers = scanner.nextLine().split(" ").map(_.toInt)

  println(apply(numbers.head, numbers.last))

  def apply(a: Int, b: Int): Int = {
    val sorted = List(a, b).sorted
    val first = sorted.last
    val second = sorted.head

    println(s"first: $first, second: $second")

    if (second == 0) first
    else apply(second, first % second)
  }
}
