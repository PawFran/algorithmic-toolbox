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

  def compute(seq: Seq[Int]): Int = {
    if (seq.size == 1) {
      seq.head
    } else {
      val middleIndex = seq.size / 2
      val (leftSeq, rightSeq) = seq.splitAt(middleIndex)

      val leftMajority = compute(leftSeq)
      val rightMajority = compute(rightSeq)

      mergeResults(seq, leftMajority, rightMajority)
    }
  }

  private def mergeResults(seq: Seq[Int], leftMajority: Int, rightMajority: Int) = {
    if (leftMajority == rightMajority) {
      leftMajority
    } else {
      val threshold = seq.size / 2 + 1
      val leftCandidateOverallCount = seq.count(_ == leftMajority)
      val rightCandidateOverallCount = seq.count(_ == rightMajority)

      if (leftCandidateOverallCount >= threshold)
        leftMajority
      else if (rightCandidateOverallCount >= threshold)
        rightMajority
      else -1
    }
  }

}
