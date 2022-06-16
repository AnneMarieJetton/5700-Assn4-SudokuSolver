package Strategies

import Parts.Cell
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DuplicatesTest {

    @Test
    fun getRow() {
        var sudokuCells = mutableListOf<Cell>()
        var valueList = mutableListOf<String>()

        while(valueList.size != 4){
            valueList.add(valueList.size.toString())
        }

        while(sudokuCells.size != 16){
            sudokuCells.add(Cell(0,0,0,"-", valueList))
        }

        var duplicates = Duplicates()
        var row = duplicates.getRow(sudokuCells, 0)

        assertEquals(sudokuCells, row)
    }

    @Test
    fun getCol() {
        var sudokuCells = mutableListOf<Cell>()
        var valueList = mutableListOf<String>()

        while(valueList.size != 4){
            valueList.add(valueList.size.toString())
        }

        while(sudokuCells.size != 16){
            sudokuCells.add(Cell(0,0,0,"-", valueList))
        }

        var duplicates = Duplicates()
        var col = duplicates.getRow(sudokuCells, 0)

        assertEquals(sudokuCells, col)
    }

    @Test
    fun getBox() {
        var sudokuCells = mutableListOf<Cell>()
        var valueList = mutableListOf<String>()

        while(valueList.size != 4){
            valueList.add(valueList.size.toString())
        }

        while(sudokuCells.size != 16){
            sudokuCells.add(Cell(0,0,0,"-", valueList))
        }

        var duplicates = Duplicates()
        var box = duplicates.getRow(sudokuCells, 0)

        assertEquals(sudokuCells, box)
    }

    @Test
    fun findDuplicates(){
        var sudokuCells = mutableListOf<Cell>()
        var valueList = mutableListOf<String>()
        var otherList = mutableListOf<String>()
        var row = mutableListOf<Cell>()
        var col = mutableListOf<Cell>()
        var box = mutableListOf<Cell>()

        while(valueList.size != 4){
            valueList.add(valueList.size.toString())
            otherList.add(valueList.size.toString())
            otherList.add((valueList.size + 10).toString())
        }

        while(sudokuCells.size != 2){
            var cell = Cell(0,0,0,"-", valueList)
            sudokuCells.add(cell)
            row.add(cell)
            col.add(cell)
            box.add(cell)
        }
        sudokuCells.add(Cell(0,0,0,"-", otherList))

        var duplicates = Duplicates()
        var found = duplicates.findDuplicates(sudokuCells[0], sudokuCells, row, col, box)

        assertEquals(true, found)
    }

}