package Strategies

import Parts.Cell
import SolveTemplate

class Duplicates: SolveTemplate() {

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
//
//        //get the list in the diplicates
//        for (cell in sudokuCells){
//            //check all cells in row
//                //get all cells with duplicate possible values
//                //make sure there is the same number of cells as possible values
//            //for cell in row
//                //remove members from row possibilities
//            //check all cells in col
//            //check all cells in box                                      klj]j'
//
//        }
//
//
//        //remove that list from every other cell
//
//        return changed
//    }


}