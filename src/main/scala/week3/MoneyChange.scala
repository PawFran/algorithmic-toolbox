package week3

import java.util.Scanner

/**
  * Task. The goal in this problem is to find the minimum number of coins needed to change the input value
  * (an integer) into coins with denominations 1, 5, and 10.
  * Input Format. The input consists of a single integer m.
  * Constraints. 1 ≤ m ≤ 10 3.
  * Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes m
  */
object MoneyChange extends App {
  private val scanner = new Scanner(System.in)
  private val number = scanner.nextLine().toInt

  println(compute(number))

  def compute(m: Int, current: Int = 0): Int = {
    val tens = m / 10
    val fives = (m - 10 * tens) / 5
    val ones = m - 10 * tens - 5 * fives

    tens + fives + ones
  }

}
