package Strategies

import Parts.Cell
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NumbersFoundElsewhereTest {

    @Test
    fun updateCellOptions() {
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

        var numbersFoundElsewhere = NumbersFoundElsewhere()
        var updated = numbersFoundElsewhere.updateCellOptions(sudokuCells[0], row, col, box)

        assertEquals(true, updated)
    }


}