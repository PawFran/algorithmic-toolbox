package week2

/**
  * Task. Given an integer n, find the nth Fibonacci number F n .
  * Input Format. The input consists of a single integer n.
  * Constraints. 0 ≤ n ≤ 45.
  * Output Format. Output F n .
  */
object Fibonacci extends App {
  private val scanner = new java.util.Scanner(System.in)
  private val number = scanner.nextLine().toInt

  println(apply(number))

  def apply(number: Int): Int = {
    number match {
      case 0 => 0
      case 1 => 1
      case n if n > 1 && n <= 45 =>
        var first = 0
        var second = 1
        var res = 1
        (2 to n).foreach { _ =>
          res = first + second
          first = second
          second = res
        }
        res
    }
  }
}
