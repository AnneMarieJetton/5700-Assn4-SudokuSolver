package Strategies

import Parts.Cell
import SolveTemplate

class Duplicates: SolveTemplate() {

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
        var changed = false

        var duplicateList = mutableListOf<Cell>()
        for (otherCell in row){
            var iterator = 0
            var listsAreEqual = true
            duplicateList.clear()

            for(value in cell.possibleValues) {
                if (value != otherCell.possibleValues[iterator]){
                    listsAreEqual = false
                }
                iterator++
            }

            if(listsAreEqual){
                duplicateList.add(otherCell)
            }
        }
        for(otherCell in row){
            if (duplicateList.size == duplicateList[0].possibleValues.size){
                if (!duplicateList.contains(otherCell)){
                    for(value in duplicateList[0].possibleValues){
                        otherCell.possibleValues.remove(value)
                    }
                }
            }
        }

        for (otherCell in col){
            var iterator = 0
            var listsAreEqual = true
            duplicateList.clear()

            for(value in cell.possibleValues) {
                if (value != otherCell.possibleValues[iterator]){
                    listsAreEqual = false
                }
                iterator++
            }

            if(listsAreEqual){
                duplicateList.add(otherCell)
            }
        }
        for(otherCell in col){
            if (duplicateList.size == duplicateList[0].possibleValues.size){
                if (!duplicateList.contains(otherCell)){
                    for(value in duplicateList[0].possibleValues){
                        otherCell.possibleValues.remove(value)
                    }
                }
            }
        }

        for (otherCell in box){
            var iterator = 0
            var listsAreEqual = true
            duplicateList.clear()

            for(value in cell.possibleValues) {
                if (value != otherCell.possibleValues[iterator]){
                    listsAreEqual = false
                }
                iterator++
            }

            if(listsAreEqual){
                duplicateList.add(otherCell)
            }
        }
        for(otherCell in box){
            if (duplicateList.size == duplicateList[0].possibleValues.size){
                if (!duplicateList.contains(otherCell)){
                    for(value in duplicateList[0].possibleValues){
                        otherCell.possibleValues.remove(value)
                    }
                }
            }
        }

        return changed
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