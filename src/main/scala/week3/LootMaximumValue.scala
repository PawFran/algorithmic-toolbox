package week3

import java.util.Scanner

/**
  * Input Format. The first line of the input contains the number n of items and the capacity W of a knapsack.
  * The next n lines define the values and weights of the items. The i-th line contains integers v i and w i —the
  * value and the weight of i-th item, respectively.
  * Constraints. 1 ≤ n ≤ 10 3 , 0 ≤ W ≤ 2 · 10 6 ; 0 ≤ v i ≤ 2 · 10 6 , 0 < w i ≤ 2 · 10 6 for all 1 ≤ i ≤ n. All the
  * numbers are integers.
  * Output Format. Output the maximal value of fractions of items that fit into the knapsack. The absolute
  * value of the difference between the answer of your program and the optimal value should be at most
  * 10 −3 . To ensure this, output your answer with at least four digits after the decimal point (otherwise
  */
object LootMaximumValue extends App {
  private val scanner = new Scanner(System.in)
  private val firstLine = scanner.nextLine().split(" ")

  private val nrOfItems = firstLine.head.toInt
  private val capacity = firstLine.last.toInt

  private val items = (for (i <- 1 to nrOfItems) yield {
    val currentLine = scanner.nextLine().split(" ").map(_.toInt)
    Item(currentLine.head, currentLine.last)
  })

  println(compute(items))

  def compute(items: IndexedSeq[Item], capacity: Int = capacity) = {
    val sorted = items.sortBy(item => item.value / item.weight.toDouble).reverse
    computeForSortedSequence(sorted, capacityLeft=capacity)
  }

  @scala.annotation.tailrec
  private def computeForSortedSequence(itemsSortedByRatio: IndexedSeq[Item], capacityLeft: Int, valueAccumulated: Int = 0): Double = {
    if (itemsSortedByRatio.isEmpty) {
      valueAccumulated
    } else {
      val currentItem = itemsSortedByRatio.head
      val weight = currentItem.weight
      val value = currentItem.value
      if (weight > capacityLeft) {
        capacityLeft / weight.toDouble * value + valueAccumulated
      } else {
        computeForSortedSequence(itemsSortedByRatio.tail, capacityLeft - weight, valueAccumulated + value)
      }
    }
  }

}

case class Item(value: Int, weight: Int)
