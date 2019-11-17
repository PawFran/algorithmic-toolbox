package week3

import java.util.Scanner

/**
 * Input Format. The first line contains an integer d. The second line contains an integer m. The third line
 * specifies an integer n. Finally, the last line contains integers stop 1 , stop 2 , . . . , stop n .
 * Output Format. Assuming that the distance between the cities is d miles, a car can travel at most m miles
 * on a full tank, and there are gas stations at distances stop 1 , stop 2 , . . . , stop n along the way, output the
 * minimum number of refills needed. Assume that the car starts with a full tank. If it is not possible to
 * reach the destination, output −1.
 * Constraints. 1 ≤ d ≤ 10 5 . 1 ≤ m ≤ 400. 1 ≤ n ≤ 300. 0 < stop 1 < stop 2 < · · · < stop n < d.
 */
object CarFueling extends App {
  private val scanner = new Scanner(System.in)

  private val distance = scanner.nextLine().split(" ").head.toInt
  private val tankCapacity = scanner.nextLine().split(" ").head.toInt
  private val nrOfStops = scanner.nextLine().split(" ").head.toInt

  private val stops = scanner.nextLine().split(" ").map(_.toInt)

  println(compute(distance, tankCapacity, stops))

  @scala.annotation.tailrec
  def compute(distance: Int, tankCapacity: Int, stops: Seq[Int],
              lastStop: Int = 0, refills: Int = 0): Int = {
    val maximumPossibleDistance = lastStop + tankCapacity
    if (maximumPossibleDistance >= distance) {
      refills
    } else {
      val reachable = stops.filter(_ <= maximumPossibleDistance)
      if (reachable.isEmpty) {
        -1
      } else {
        val unreachable = stops.filter(_ > maximumPossibleDistance)
        compute(distance, tankCapacity, stops = unreachable, lastStop = reachable.last, refills=refills+1)
      }
    }
  }
}
