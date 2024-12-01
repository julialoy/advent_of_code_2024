fun solveDay1Puzzle2() {
    val puzzleInputAsList = parsePuzzleInputToList("./resources/day_01_puzzle_01_input.txt")
    val (leftHandList, rightHandList) = parseCombinedList(puzzleInputAsList)
    var similarityScore = 0

    for (num in leftHandList) {
        val ocurrCount = rightHandList.count { it == num }
        similarityScore += num * ocurrCount
    }

    println(similarityScore)
}