package week6

import java.util.Scanner

/**
 * Task. Given n gold bars, find the maximum weight of gold that fits into a bag of capacity W .
 * Input Format. The first line of the input contains the capacity W of a knapsack and the number n of bars
 * of gold. The next line contains n integers w 0 , w 1 , . . . , w n−1 defining the weights of the bars of gold.
 * Constraints. 1 ≤ W ≤ 10 4 ; 1 ≤ n ≤ 300; 0 ≤ w 0 , . . . , w n−1 ≤ 10 5 .
 * Output Format. Output the maximum weight of gold that fits into a knapsack of capacity W .
 */
object MaximumAmountOfGold extends App {
  private val scanner = new Scanner(System.in)

  private val firstLine = scanner.nextLine().split(" ").map(_.toInt)

  private val capacity = firstLine.head

  private val weights = scanner.nextLine().split(" ").map(_.toInt)

  println(compute(weights, capacity))

  def compute(weights: Array[Int], capacity: Int): Int = {
    val subproblems = Array.ofDim[Int](capacity + 1, weights.length + 1)

    val numberOfItems = weights.length

    // initialize first row and column
    (1 to  capacity) foreach {w => subproblems(w)(0) == 0}
    (1 to numberOfItems) foreach {i => subproblems(0)(i) == 0}

    // calculate values for all subproblems
    (1 to numberOfItems) foreach { i =>
      (1 to capacity) foreach { w =>
        if (weights(i-1) > w) {
          subproblems(w)(i) = subproblems(w)(i-1)
        } else {
          subproblems(w)(i) = Math.max(
            subproblems(w - weights(i-1))(i-1) + weights(i-1),
            subproblems(w)(i-1)
          )
        }
      }
    }

    subproblems.last.last
  }

}
