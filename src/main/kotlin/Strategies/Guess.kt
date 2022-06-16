package Strategies

import Parts.Cell
import SolveTemplate

class Guess: SolveTemplate()  {

    override fun getRow(sudokuCells: MutableList<Cell>, rowIndex: Int): MutableList<Cell> {
        var returnableRow = mutableListOf<Cell>()

        for(cell in sudokuCells){
            if(cell.colIndex == rowIndex){
                returnableRow.add(cell)
            }
        }

        return returnableRow
    }

    override fun getCol(sudokuCells: MutableList<Cell>, colIndex: Int): MutableList<Cell> {
        var returnableCol = mutableListOf<Cell>()

        for(cell in sudokuCells){
            if(cell.colIndex == colIndex){
                returnableCol.add(cell)
            }
        }

        return returnableCol
    }

    override fun getBox(sudokuCells: MutableList<Cell>, boxIndex: Int): MutableList<Cell> {
        var returnableBox = mutableListOf<Cell>()

        for(cell in sudokuCells){
            if (cell.boxIndex == boxIndex){
                returnableBox.add(cell)
            }
        }

        return returnableBox
    }

    override fun updateCellOptions(cell: Cell, row: MutableList<Cell>, col: MutableList<Cell>, box: MutableList<Cell>): Boolean {
        return false
    }

    override fun findDuplicates(cell: Cell, sudokuCells: MutableList<Cell>, row: MutableList<Cell>, col: MutableList<Cell>, box: MutableList<Cell>): Boolean {
        return false
    }

    override fun updateCellValue(cell: Cell): Boolean {
        var changed = false

        if (!cell.possibleValues.isEmpty()){
            cell.currentValue = cell.possibleValues[0]
            cell.possibleValues.remove(cell.currentValue)
        }

        return changed
    }

}