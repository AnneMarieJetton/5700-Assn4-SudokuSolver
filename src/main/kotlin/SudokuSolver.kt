import Parts.Cell
import Strategies.*
import java.io.File
import java.util.ArrayDeque

class SudokuSolver (_sudokuPuzzleFile: File){
    val sudokuPuzzleFile: File = _sudokuPuzzleFile
    var sudokuCells: MutableList<Cell>? = mutableListOf()
    var solutions = mutableListOf<Solution>()
    var sudokuDimension = 0
    var strategyCount = mutableListOf<Int>()

    init {
        makeCells()
    }

    fun solveSudoku(): MutableList<Solution> {
        if(!checkSizeValidity()){
            return solutions
        }

        var numbersFoundElsewhere = NumbersFoundElsewhere()
        var duplicates = Duplicates()
        var onlyOnePossibility = OnlyOnePossibility()
        var guess = Guess()

        while(sudokuCells != null){
            var changes = false
            var puzzleStack = ArrayDeque<MutableList<Cell>>()
            var strategyStack = ArrayDeque<Int>()

            if(!numbersFoundElsewhere.runStrategy(sudokuCells!!)){
                if(!duplicates.runStrategy(sudokuCells!!)){
                    if (!onlyOnePossibility.runStrategy(sudokuCells!!)){
                        if(!guess.runStrategy(sudokuCells!!)){
                            if (puzzleStack.isEmpty())
                                sudokuCells = null
                            else {
                                sudokuCells = puzzleStack.pop()
                            }
                        }
                        else{
                            changes = true
                            strategyCount[3] = strategyCount[3] + 1
                            puzzleStack.push(sudokuCells)
                        }
                    }
                    else{
                        changes = true
                        strategyCount[2] = strategyCount[2] + 1
                    }
                }
                else{
                    changes = true
                    strategyCount[1] = strategyCount[1] + 1
                }
            }
            else{
                changes = true
                strategyCount[0] = strategyCount[0] + 1
            }

            if (changes == true){
                if(sudokuCells?.let { sudokuIsSolved(it) } == true){
                    solutions.add(Solution(sudokuCells!!, strategyCount))
                }
            }

        }

        return solutions
    }

    private fun sudokuIsSolved(puzzle: MutableList<Cell>): Boolean {
        for (cell in puzzle){
            if (cell.currentValue == "_"){
                return false
            }
        }

        return true

    }

    private fun checkSizeValidity(): Boolean {
        val sq = Math.sqrt(sudokuDimension.toDouble())
        val f = Math.floor(sq)

        if (sq == f){
            return true
        }

        return false
    }

    private fun makeCells(){
        var possibleValues = mutableListOf<String>()
        var puzzleLines = mutableListOf<String>()

        var i = 0
        sudokuPuzzleFile.forEachLine{
            if (i == 0){
                sudokuDimension = it.toInt()
            }
            else if(i == 1){
                var splitLine = it.split(" ").toMutableList()
                possibleValues = splitLine
            }
            else{
                puzzleLines.add(it)
            }
            i++
        }

        var row = 0
        for(line in puzzleLines) {

            var splitLine = line.split(" ").toMutableList()
            var col = 0
            for(char in splitLine){
                sudokuCells?.add(Cell(row, col, createBoxIndex(row, col), char, possibleValues))
                col++
            }
            row++
        }

    }

    private fun createBoxIndex(desiredRow: Int, desiredCol: Int): Int {
        var boxSize = Math.sqrt(sudokuDimension.toDouble()).toInt()
        var overallIndex = 0
        var colIndex = 0
        var rowIndex = 0
        var boxIndex = 0
        var boxDecisiveCounterRow = 0
        var boxDecisiveCounterCol = 0
        var forSomeGodForsakenReasonICantReturnInsideAForLoop = -1

        sudokuPuzzleFile.forEachLine{
            var splitLine = it.split(" ")
            for (char in splitLine){
                if(rowIndex == desiredRow && colIndex == desiredCol){
                    forSomeGodForsakenReasonICantReturnInsideAForLoop = boxIndex
                }
                else{
                    colIndex++
                    boxDecisiveCounterCol++
                    if(boxDecisiveCounterCol == boxSize){
                        boxDecisiveCounterCol = 0
                        boxIndex++
                    }
                    if (colIndex == sudokuDimension){
                        colIndex = 0
                        rowIndex++

                        boxDecisiveCounterRow++
                        if(boxDecisiveCounterRow == boxSize){
                            boxDecisiveCounterRow = 0
                        }
                        else{
                            boxIndex = boxIndex - (boxSize-1)
                        }
                    }
                }
                overallIndex++
            }
        }

        return forSomeGodForsakenReasonICantReturnInsideAForLoop
    }

}