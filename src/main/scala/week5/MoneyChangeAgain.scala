package week5

import java.util.Scanner

/**
  * Input Format. Integer money.
  * Output Format. The minimum number of coins with denominations 1, 3, 4 that changes money.
  * Constraints. 1 ≤ money ≤ 10 3 .
  */
object MoneyChangeAgain extends App {
  private val scanner = new Scanner(System.in)
  private val money = scanner.nextLine().toInt

  println(compute(money))

  def compute(number: Int): Int = {
    val coins = Array.fill(number + 1) {0}

    (1 to number).foreach { idx =>
      if (idx < 3) coins(idx) = coins(idx - 1) + 1
      else if (idx < 4) coins(idx) = Math.min(coins(idx - 1), coins(idx - 3)) + 1
      else coins(idx) = Array(coins(idx - 1), coins(idx - 3), coins(idx - 4)).min + 1
    }

    coins.last
  }

}
