package week4

import java.util.Scanner

/**
  * Task. The goal in this code problem is to implement the binary search algorithm.
  * Input Format. The first line of the input contains an integer n and a sequence a 0 < a 1 < . . . < a n−1
  * of n pairwise distinct positive integers in increasing order. The next line contains an integer k and k
  * positive integers b 0 , b 1 , . . . , b k−1 .
  * Constraints. 1 ≤ n, k ≤ 10 4 ; 1 ≤ a i ≤ 10 9 for all 0 ≤ i < n; 1 ≤ b j ≤ 10 9 for all 0 ≤ j < k;
  * Output Format. For all i from 0 to k − 1, output an index 0 ≤ j ≤ n − 1 such that a j = b i or −1 if there
  * is no such index.
  */
object BinarySearch extends App {
  private val scanner = new Scanner(System.in)

  private val allNumbers = scanner.nextLine().split(" ").map(_.toInt)
  private val toBeFound = scanner.nextLine().split(" ").map(_.toInt).tail

  toBeFound.foreach(number => print(apply(allNumbers, number)) + " ")

  def apply(numbersAsc: Array[Int], toBeFound: Int): Int = {
    if (numbersAsc.isEmpty) return -1

    val middleIndex = numbersAsc.length / 2
    val middleElement = numbersAsc(middleIndex)

    if (middleElement == toBeFound) middleIndex
    else if (toBeFound > middleElement) apply(numbersAsc.splitAt(middleIndex)._2.tail, toBeFound)
    else apply(numbersAsc.splitAt(middleIndex)._1, toBeFound)
  }
}
