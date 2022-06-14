import Parts.Cell
import java.io.File

class SudokuSolver (_sudokuPuzzleFile: File){
    val sudokuPuzzleFile: File = _sudokuPuzzleFile
    var sudokuCells = mutableListOf<Cell>()
    var solutions = mutableListOf<Solution>()
    var sudokuDimension = 0

    init {
        makeCells()
    }

    fun solveSudoku(): MutableList<Solution> {
        if(!checkSizeValidity()){
            return solutions
        }

        return solutions
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
                sudokuCells.add(Cell(row, col, sudokuDimension, char, possibleValues))
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

//    private fun setDimension(){
//
//    }

    private fun getCellRow(sudoku: MutableList<Cell>, size: Int, neededRowIndex: Int): MutableList<Cell> {
//        var currentRowIndex = 0
//        var cellIndexInCurrentRow = 0
        var returnableRow = mutableListOf<Cell>()
//        for(cell in sudoku){
//            if (currentRowIndex == neededRowIndex) {
//                returnableRow.add(cell)
//            }
//            else{
//                cellIndexInCurrentRow++
//                if (cellIndexInCurrentRow == size){
//                    cellIndexInCurrentRow = 0
//                    currentRowIndex++
//                }
//            }
//        }
        for(cell in sudoku){
            if(cell.colIndex == neededRowIndex){
                returnableRow.add(cell)
            }
        }

        return returnableRow
    }

    private fun getCellCol(sudoku: MutableList<Cell>, size: Int, neededColIndex: Int): MutableList<Cell> {
//        var cellIndexInCurrentRow = 0
        var returnableCol = mutableListOf<Cell>()
//        for(cell in sudoku){
//            if(cellIndexInCurrentRow == neededColIndex){
//                returnableCol.add(cell)
//            }
//            else{
//                cellIndexInCurrentRow++
//                if (cellIndexInCurrentRow == size){
//                    cellIndexInCurrentRow = 0
//                }
//            }
//        }
        for(cell in sudoku){
            if(cell.colIndex == neededColIndex){
                returnableCol.add(cell)
            }
        }

        return returnableCol
    }

    private fun getCellBox(sudoku: MutableList<Cell>, size: Int, neededBoxIndex: Int): MutableList<Cell> {
//        var currentRowIndex = 0
//        var cellIndexInCurrentRow = 0
        var returnableBox = mutableListOf<Cell>()
//        var boxSize = Math.sqrt(size.toDouble())
//        for (cell in sudoku){
//
//        }
        for(cell in sudoku){
            if (cell.boxIndex == neededBoxIndex){
                returnableBox.add(cell)
            }
        }

        return returnableBox
    }


}