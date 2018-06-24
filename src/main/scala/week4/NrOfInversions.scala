package week4

import java.util.Scanner

/**
  * Task. The goal in this problem is to count the number of inversions of a given sequence.
  * Input Format. The first line contains an integer n, the next one contains a sequence of integers
  * a 0 , a 1 , . . . , a n−1 .
  * Constraints. 1 ≤ n ≤ 10 5 , 1 ≤ a i ≤ 10 9 for all 0 ≤ i < n.
  * Output Format. Output the number of inversions in the sequence.
  */
object NrOfInversions extends App {
  private val scanner = new Scanner(System.in)

  private val inputSize = scanner.nextLine().toInt
  private val numbers = scanner.nextLine().split(" ").map(_.toInt)

  println(compute(numbers).nrOfInversions)

  def compute(numbers: Array[Int], nrOfInversions: Int = 0): Result = {
    if (numbers.length == 1) Result(Array(numbers.head), nrOfInversions)
    else {
      val middleIndex = numbers.length / 2
      val firstHalf = numbers.splitAt(middleIndex)._1
      val secondHalf = numbers.splitAt(middleIndex)._2
      val a = compute(firstHalf, nrOfInversions)
      val b = compute(secondHalf, nrOfInversions)
      helper(a.arr, b.arr, Result(Array.empty, a.nrOfInversions + b.nrOfInversions))
    }
  }

  def helper(a: Array[Int], b: Array[Int], summary: Result): Result = {
    if (a.isEmpty && b.isEmpty) summary
    else if (a.isEmpty) Result(summary.arr ++ b, summary.nrOfInversions)
    else if (b.isEmpty) Result(summary.arr ++ a, summary.nrOfInversions + a.length)
    else if (a.head <= b.head) helper(a.tail, b, Result(summary.arr ++ Array(a.head), summary.nrOfInversions))
    else helper(a, b.tail, Result(summary.arr ++ Array(b.head), summary.nrOfInversions + 1))
  }

  case class Result(arr: Array[Int], nrOfInversions: Int)
}
