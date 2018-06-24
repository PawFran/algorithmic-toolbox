package week2

/**
  * Task. Given an integer n, find the last digit of the nth Fibonacci number F n (that is, F n mod 10).
  * Input Format. The input consists of a single integer n.
  * Constraints. 0 ≤ n ≤ 10 7 .
  * Output Format. Output the last digit of F n .
  */
object FibonacciLastDigit extends App {
  private val scanner = new java.util.Scanner(System.in)
  private val number = scanner.nextLine().toInt

  println(compute(number))

  def compute(number: Int): Int = {
    number match {
      case 0 => 0
      case 1 => 1
      case n if n > 1 && n <= math.pow(10, 7) =>
        var first = 0
        var second = 1
        var res = 1
        (2 to n).foreach { _ =>
          res = (first + second) % 10
          first = second
          second = res
        }
        res
    }
  }
}
