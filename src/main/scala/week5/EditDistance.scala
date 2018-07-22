package week5

import java.util.Scanner

object EditDistance extends App{
  private val scanner = new Scanner(System.in)
  private val strA = scanner.nextLine()
  private val strB = scanner.nextLine()

  println(compute(strA, strB))

  def compute(a: String, b: String): Int = {
    val distances = Array.ofDim[Int](b.length + 1, a.length + 1)

    for (i <- 1 to b.length) distances(i)(0) = i
    for (j <- 1 to a.length) distances(0)(j) = j

    for(i <- 1 to b.length; j <- 1 to a.length) {
      distances(i)(j) =
        if (b(i - 1) != a(j - 1)) {
          Array(
            distances(i - 1)(j) + 1,
            distances(i)(j - 1) + 1,
            distances(i - 1)(j - 1) + 1)
            .min
      } else {
          Array(
            distances(i - 1)(j) + 1,
            distances(i)(j - 1) + 1,
            distances(i - 1)(j - 1))
            .min
        }
    }

    distances(b.length)(a.length)
  }
}
