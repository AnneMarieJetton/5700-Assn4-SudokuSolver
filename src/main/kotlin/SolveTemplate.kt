import Parts.Cell

abstract class SolveTemplate {

    final fun runStrategy(sudokuCells: MutableList<Cell>): Boolean {
        var changed = false
        for(cell in sudokuCells) {

            var row = getRow(sudokuCells, cell.rowIndex)
            var col = getCol(sudokuCells, cell.colIndex)
            var box = getBox(sudokuCells, cell.boxIndex)
            changed = changed || updateCellOptions(cell, row, col, box)
            changed = changed || findDuplicates(cell, sudokuCells, row, col, box)
            changed = changed || updateCellValue(cell)

        }
        return changed
    }

    abstract fun getRow(sudokuCells: MutableList<Cell>, rowIndex: Int): MutableList<Cell>
    abstract fun getCol(sudokuCells: MutableList<Cell>, colIndex: Int): MutableList<Cell>
    abstract fun getBox(sudokuCells: MutableList<Cell>, boxIndex: Int): MutableList<Cell>
    abstract fun updateCellOptions(cell: Cell, row: MutableList<Cell>, col: MutableList<Cell>, box: MutableList<Cell>):Boolean
    abstract fun findDuplicates(cell: Cell, sudokuCells: MutableList<Cell>, row: MutableList<Cell>, col: MutableList<Cell>, box: MutableList<Cell>): Boolean
    abstract fun updateCellValue(cell: Cell): Boolean

}