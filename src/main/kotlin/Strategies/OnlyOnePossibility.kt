package Strategies

import Parts.Cell
import SolveTemplate

class OnlyOnePossibility: SolveTemplate() {

    override fun getRow(sudokuCells: MutableList<Cell>, index: Int): MutableList<Cell> {
        var returnableRow = mutableListOf<Cell>()

        for(cell in sudokuCells){
            if(cell.colIndex == index){
                returnableRow.add(cell)
            }
        }

        return returnableRow
    }

    override fun getCol(sudokuCells: MutableList<Cell>, index: Int): MutableList<Cell> {
        var returnableCol = mutableListOf<Cell>()

        for(cell in sudokuCells){
            if(cell.colIndex == index){
                returnableCol.add(cell)
            }
        }

        return returnableCol
    }

    override fun getBox(sudokuCells: MutableList<Cell>, index: Int): MutableList<Cell> {
        var returnableBox = mutableListOf<Cell>()

        for(cell in sudokuCells){
            if (cell.boxIndex == index){
                returnableBox.add(cell)
            }
        }

        return returnableBox
    }

    override fun updateCellOptions(cell: Cell, row: MutableList<Cell>, col: MutableList<Cell>, box: MutableList<Cell>): Boolean {
        TODO("Not yet implemented")
    }

    override fun findDuplicates(cell: Cell, sudokuCells: MutableList<Cell>, row: MutableList<Cell>, col: MutableList<Cell>, box: MutableList<Cell>): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateCellValue(cell: Cell): Boolean {
        var changed = false

        if(cell.possibleValues.size == 1){
            cell.currentValue = cell.possibleValues[0]
            cell.possibleValues.clear()
            changed = true
        }

        return changed
    }

}