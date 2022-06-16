package Strategies

import Parts.Cell
import SolveTemplate

class NumbersFoundElsewhere: SolveTemplate()  {

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
        var changed = false

        if (cell.initialValue != "-"){
            cell.possibleValues.clear()
        }
        else {
            for (otherCell in row){
                if (otherCell.currentValue != "-"){
                    if(cell.possibleValues.contains(otherCell.currentValue)) {
                        cell.possibleValues.remove(otherCell.currentValue)
                        changed = true
                    }
                }
            }
            for (otherCell in col){
                if (otherCell.currentValue != "-"){
                    if(cell.possibleValues.contains(otherCell.currentValue)) {
                        cell.possibleValues.remove(otherCell.currentValue)
                        changed = true
                    }
                }
            }
            for (otherCell in box){
                if (otherCell.currentValue != "-"){
                    if(cell.possibleValues.contains(otherCell.currentValue)) {
                        cell.possibleValues.remove(otherCell.currentValue)
                        changed = true
                    }
                }
            }
        }

        return changed
    }

    override fun findDuplicates(cell: Cell, sudokuCells: MutableList<Cell>, row: MutableList<Cell>, col: MutableList<Cell>, box: MutableList<Cell>): Boolean {
        return false
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