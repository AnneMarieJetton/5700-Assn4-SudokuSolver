package Strategies

import Parts.Cell
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GuessTest {

    @Test
    fun updateCellValue() {
    var valueList = mutableListOf<String>()
    valueList.add("1")
    valueList.add("2")

    var cell = Cell(0,0,0,"-", valueList)
    var onlyOnePossibility = OnlyOnePossibility()
    var didUpdate = onlyOnePossibility.updateCellValue(cell)

    assertEquals(true, didUpdate)
    assertEquals("1", cell.currentValue)
    assertEquals(1, cell.possibleValues.size)

    }
}