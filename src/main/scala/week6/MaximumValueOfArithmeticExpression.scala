package week6


/**
 * Task. Find the maximum value of an arithmetic expression by specifying the order of applying its arithmetic
 * operations using additional parentheses.
 * Input Format. The only line of the input contains a string s of length 2n + 1 for some n, with symbols
 * s 0 , s 1 , . . . , s 2n . Each symbol at an even position of s is a digit (that is, an integer from 0 to 9) while
 * each symbol at an odd position is one of three operations from {+,-,*}.
 * Constraints. 1 ≤ n ≤ 14 (hence the string contains at most 29 symbols).
 * Output Format. Output the maximum possible value of the given arithmetic expression among different
 * orders of applying arithmetic operations.
 */
object MaximumValueOfArithmeticExpression extends App {

  def compute(numbers: Array[Int], operators: Array[String]): Int = {
    val n = numbers.length
    val mins: Array[Array[Int]] = Array.ofDim(n, n)
    val maxs: Array[Array[Int]] = Array.ofDim(n, n)

    0 until n foreach { i =>
      mins(i)(i) = numbers(i)
      maxs(i)(i) = numbers(i)
    }

    1 until n foreach { s =>
      0 until (n-s) foreach { i =>
        val j = i + s
        val (min, max) = minAndMax(i, j, mins, maxs, operators)
        mins(i)(j) = min
        maxs(i)(j) = max
      }
    }

    maxs(0)(n-1)
  }

  private def minAndMax(i: Int, j: Int,
                        mins: Array[Array[Int]], maxs: Array[Array[Int]],
                        operators: Array[String]): (Int, Int) = {

    var max = Integer.MIN_VALUE
    var min = Integer.MAX_VALUE

    i until j foreach { k =>
      val opk = operators(k)

      val a = maxs(i)(k).op(opk)(maxs(k+1)(j))
      val b = maxs(i)(k).op(opk)(mins(k+1)(j))
      val c = mins(i)(k).op(opk)(maxs(k+1)(j))
      val d = mins(i)(k).op(opk)(mins(k+1)(j))

      min = Array(min, a, b, c, d).min
      max = Array(max, a, b, c, d).max
    }

    (min, max)
  }

  implicit class RichInt(i: Int) {
    def op(operator: String)(j: Int): Int = operator match {
      case "+" => i + j
      case "-" => i - j
      case "*" => i * j
    }
  }
}
