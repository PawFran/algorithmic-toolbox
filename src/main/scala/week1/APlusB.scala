package week1

/**
  * Input format. Integers a and b on the same line (separated by a space).
  * Output format. The sum of a and b.
  * Constraints. 0 ≤ a, b ≤ 9.
  */
object APlusB extends App {
  override def main(args: Array[String]): Unit = {
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine()
    val result = (line.split(" ").map( x => BigInt(x)) take 2).sum
      System.out.print(result )
  }
}