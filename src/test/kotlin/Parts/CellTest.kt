package Parts

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CellTest {

    @Test
    fun getId() {
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

        var cell = Cell(0,0,0,"-", valueList)


        assertEquals("-", cell.currentValue)
        assertEquals(4, cell.possibleValues.size)
    }

}