import kotlin.math.abs

fun isDifferenceSafe(puzzleLine: MutableList<Int>): Boolean {
    // val unsafeLevelsByDifference = mutableListOf<Int>()
    for (i in 0 until puzzleLine.size-1) {
        val diff = abs(puzzleLine[i] - puzzleLine[i+1])
        if ( diff > 3 || diff <= 0) {
            return false
        }
    }
    return true
}

fun isIncreasingSafe(puzzleLine: MutableList<Int>): Boolean {
    for (i in 0 until puzzleLine.size-1) {
        if (puzzleLine[i] >= puzzleLine[i+1]) {
            return false
        }
    }
    return true
}

fun isDeacreasingSafe(puzzleLine: MutableList<Int>): Boolean {
    for (i in 0 until puzzleLine.size-1) {
        if (puzzleLine[i] <= puzzleLine[i+1]) {
            return false
        }
    }
    return true
}


fun solveDay2Puzzle2() {
    val puzzleInputAsList = splitPuzzleLines("./resources/day_02_puzzle_input.txt")
    var numSafeRecords = 0

    for (line in puzzleInputAsList) {

        if (isDifferenceSafe(line) && (isDeacreasingSafe(line) || isIncreasingSafe(line))) {
            numSafeRecords += 1
            continue
        }

        for (i in 0 until line.size) {
            val tempLine = line.toMutableList()
            tempLine.removeAt(i)
            var isRecordSafe = isDifferenceSafe(tempLine)
            if (isRecordSafe and isIncreasingSafe(tempLine)) {
                numSafeRecords += 1
                break
            } else if (isRecordSafe and isDeacreasingSafe(tempLine)) {
                numSafeRecords += 1
                break
            }
        }
    }

    println(numSafeRecords)
}
