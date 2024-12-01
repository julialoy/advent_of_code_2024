import java.io.File
import kotlin.math.max
import kotlin.math.min

// Read in puzzle input as a stream
fun readInPuzzleInputAsStream(puzzleInput: String) = File(puzzleInput).inputStream().readBytes().toString(Charsets.UTF_8)

// Split each line on whitespace and cast each resulting string to an integer
fun processPuzzleLines(line: String): Pair<Int?, Int?> {
    // Remove extra whitespace between numbers
    val pattern = Regex("\\s+")
    val fixedLine = line.replace(pattern, " ")

    val (leftStr, rightStr) = fixedLine.split(" ")
    val leftInt = leftStr.toIntOrNull()
    val rightInt = rightStr.toIntOrNull()

    return Pair(leftInt, rightInt)
}

// Combine each processed line into a list of tuples containing two integers
fun parsePuzzleInputToList(filename: String): MutableList<Pair<Int?, Int?>> {
    val puzzleInputStream = readInPuzzleInputAsStream(filename)
    val combinedList = mutableListOf<Pair<Int?, Int?>>()

    puzzleInputStream.reader().forEachLine { ln -> combinedList.add(processPuzzleLines(ln)) }

    return combinedList
}

// Break combined list apart into a left and right list for easy manipulation
fun parseCombinedList(initialList: MutableList<Pair<Int?, Int?>>): Pair<MutableList<Int>, MutableList<Int>> {
    var leftList = mutableListOf<Int>()
    var rightList = mutableListOf<Int>()

    // Break up combined list and cast to nonnullable int
    // Puzzle input guarantees numbers are integers
    for (listPair in initialList) {
        leftList.add(listPair.first!!)
        rightList.add(listPair.second!!)
    }

    // Sort lists
    leftList = leftList.sorted().toMutableList()
    rightList = rightList.sorted().toMutableList()

    return Pair(leftList, rightList)
}

fun main() {
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