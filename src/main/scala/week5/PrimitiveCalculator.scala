package week5

import java.util.Scanner
import scala.collection.mutable

/**
  * Task. Given an integer n, compute the minimum number of operations needed to obtain the number n
  * starting from the number 1.
  * Input Format. The input consists of a single integer 1 ≤ n ≤ 10 6 .
  * Output Format. In the first line, output the minimum number k of operations needed to get n from 1.
  * In the second line output a sequence of intermediate numbers. That is, the second line should contain
  * positive integers a 0 , a 2 , . . . , a k−1 such that a 0 = 1, a k−1 = n and for all 0 ≤ i < k − 1, a i+1 is equal to
  * either a i + 1, 2a i , or 3a i . If there are many such sequences, output any one of them.
  */
object PrimitiveCalculator extends App {
  private val scanner = new Scanner(System.in)
  private val number = scanner.nextLine().toInt

  private val arrayOfIntermediaryNumbers = compute(number)

  println(arrayOfIntermediaryNumbers.length - 1)
  println(arrayOfIntermediaryNumbers)

  def compute(number: Int): List[Int] = {
    val opsNr = Array.fill(number) {0}
    val intermediaryNumbers = mutable.Map(1 -> mutable.ListBuffer(1))

    (2 to number).foreach { i =>
      (i % 3 == 0, i % 2 == 0) match {
        case (true, true) =>
          val previousNr = opsNr.zipWithIndex
            .filter(el => el._2 == i / 3 - 1 || el._2 == i / 2 - 1 || el._2 == i - 1 - 1)
            .minBy(_._1)
            ._2 + 1

          opsNr(i - 1) = opsNr(previousNr - 1) + 1
          intermediaryNumbers(i) = intermediaryNumbers(previousNr) :+ i
        case (false, true) =>
          val previousNr = opsNr.zipWithIndex
            .filter(el => el._2 == i / 2 - 1 || el._2 == i - 1 - 1)
            .minBy(_._1)
            ._2 + 1

          opsNr(i - 1) = opsNr(previousNr - 1) + 1
          intermediaryNumbers(i) = intermediaryNumbers(previousNr) :+ i
        case (true, false) =>
          val previousNr = opsNr.zipWithIndex
            .filter(el => el._2 == i / 3 - 1 || el._2 == i - 1 - 1)
            .minBy(_._1)
            ._2 + 1

          opsNr(i - 1) = opsNr(previousNr - 1) + 1
          intermediaryNumbers(i) = intermediaryNumbers(previousNr) :+ i
        case (false, false) =>
          val previousNr = opsNr.zipWithIndex
            .filter(el => el._2 == i - 1 - 1)
            .minBy(_._1)
            ._2 + 1

          opsNr(i - 1) = opsNr(previousNr - 1) + 1
          intermediaryNumbers(i) = intermediaryNumbers(previousNr) :+ i
      }
    }

    intermediaryNumbers(number).toList
  }
}
