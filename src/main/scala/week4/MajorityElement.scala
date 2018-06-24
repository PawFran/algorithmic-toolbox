package week4

import java.util.Scanner

/**
  * Task. The goal in this code problem is to check whether an input sequence contains a majority element.
  * Input Format. The first line contains an integer n, the next one contains a sequence of n non-negative
  * integers a 0 , a 1 , . . . , a n−1 .
  * Constraints. 1 ≤ n ≤ 10 5 ; 0 ≤ a i ≤ 10 9 for all 0 ≤ i < n.
  * Output Format. Output 1 if the sequence contains an element that appears strictly more than n/2 times,
  * and 0 otherwise.
  */
object MajorityElement extends App {
  private val scanner = new Scanner(System.in)
  private val number = scanner.nextLine().toInt

  private val numbers = scanner.nextLine().split(" ").map(_.toInt)

  println(if (compute(numbers) == -1) 0 else 1)

  def compute(arr: Array[Int]): Int = {
    if (arr.length == 1) return arr.head

    val middleIndex = arr.length / 2
    val (firstHalf, secondHalf) = arr.splitAt(middleIndex)

    val first = compute(firstHalf)
    val second = compute(secondHalf)

    if (secondHalf.length > firstHalf.length) second // second half will sometimes be larger
    else if (firstHalf contains second) first
    else if (secondHalf contains first) second
    else -1
  }
}
