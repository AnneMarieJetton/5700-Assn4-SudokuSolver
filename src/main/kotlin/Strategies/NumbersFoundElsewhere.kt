package Strategies

import Parts.Cell
import SolveTemplate

class NumbersFoundElsewhere: SolveTemplate()  {

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

    override fun findDuplicates(cell: Cell, sudokuCells: MutableList<Cell>): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateCellValue(cell: Cell): Boolean {
        TODO("Not yet implemented")
    }

    //    override fun runStrategy(sudokuCells: MutableList<Cell>): Boolean {
//        var changed = false
//        for(cell in sudokuCells){
//            if (cell.currentValue != "_"){
//                cell.possibleValues.clear()
//            }
//            else {
//                for (otherCell in getRow(sudokuCells, cell.rowIndex)){
//                    if (otherCell.currentValue != "_"){
//                        if(cell.possibleValues.contains(otherCell.currentValue)) {
//                            cell.possibleValues.remove(otherCell.currentValue)
//                            changed = true
//                        }
//                    }
//                }
//                for (otherCell in getCol(sudokuCells, cell.colIndex)){
//                    if (otherCell.currentValue != "_"){
//                        if(cell.possibleValues.contains(otherCell.currentValue)) {
//                            cell.possibleValues.remove(otherCell.currentValue)
//                            changed = true
//                        }
//                    }
//                }
//                for (otherCell in getBox(sudokuCells, cell.boxIndex)){
//                    if (otherCell.currentValue != "_"){
//                        if(cell.possibleValues.contains(otherCell.currentValue)) {
//                            cell.possibleValues.remove(otherCell.currentValue)
//                            changed = true
//                        }
//                    }
//                }
//            }
//
//        }
//
//        return changed
//    }


}