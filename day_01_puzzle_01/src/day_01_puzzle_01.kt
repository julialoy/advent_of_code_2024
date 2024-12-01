import kotlin.math.max
import kotlin.math.min

fun solveDay1Puzzle1() {
    val puzzleInputAsList = parsePuzzleInputToList("./resources/day_01_puzzle_01_input.txt")
    val (leftHandList, rightHandList) = parseCombinedList(puzzleInputAsList)
    var sumOfDiffs = 0

    // Lists are known to be the same length
    for (i in leftHandList.indices) {
        val maxInt = max(leftHandList[i], rightHandList[i])
        val minInt = min(leftHandList[i], rightHandList[i])
        sumOfDiffs += maxInt - minInt
    }

    println(sumOfDiffs)
}