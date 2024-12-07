import java.io.File

fun readInPuzzleInputAsStream(puzzleInput: String) = File(puzzleInput).inputStream().readBytes().toString(Charsets.UTF_8)

fun splitPuzzleLines(filename: String): MutableList<MutableList<Int>> {
    val puzzleInputStream = readInPuzzleInputAsStream(filename)
    val puzzleInputAsList = mutableListOf<MutableList<Int>>()

    puzzleInputStream.reader().forEachLine { ln -> puzzleInputAsList.add(processPuzzleLine(ln)) }

    return puzzleInputAsList
}

fun processPuzzleLine(puzzleLine: String): MutableList<Int> {
    val stringList = puzzleLine.split(" ")
    val numList = mutableListOf<Int>()

    for (num in stringList) {
        numList.add(num.toInt())
    }

    return numList
}