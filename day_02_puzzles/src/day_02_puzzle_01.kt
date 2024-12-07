fun solveDay2Puzzle1() {
    val puzzleInputAsList = splitPuzzleLines("./resources/day_02_puzzle_input.txt")
    var numSafeRecords = 0

    for (line in puzzleInputAsList) {
        var lineIsSafe = true
        var lineDirection = ""
        for (i in 1 until (line.size)) {
            if (line[i-1] < line[i]) {
                if (lineDirection.isEmpty()) {
                    lineDirection = "inc"
                } else if (lineDirection != "inc") {
                    lineIsSafe = false
                    break
                }

                if ((line[i] - line[i-1]) > 3) {
                    lineIsSafe = false
                    break
                }
            } else if (line[i-1] > line[i]) {
                if (lineDirection.isEmpty()) {
                    lineDirection = "dec"
                } else if (lineDirection != "dec") {
                    lineIsSafe = false
                    break
                }

                if ((line[i-1] - line[i]) > 3) {
                    lineIsSafe = false
                    break
                }
            } else if (line[i] == line[i-1]) {
                lineIsSafe = false
                break
            }
        }

        if (lineIsSafe) {
            numSafeRecords += 1
        }
    }

    println(numSafeRecords)
}