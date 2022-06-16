import Parts.Cell
import Strategies.Duplicates
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SolutionTest {

    @Test
    fun getSudokuSolution() {
        var sudokuCells = mutableListOf<Cell>()
        var valueList = mutableListOf<String>()
        var otherList = mutableListOf<Int>()

        while(valueList.size != 4){
            valueList.add(valueList.size.toString())
            otherList.add((valueList.size))
        }

        while(sudokuCells.size != 2){
            var cell = Cell(0,0,0,"-", valueList)
            sudokuCells.add(cell)
        }

        var solution = Solution(sudokuCells, otherList)

        assertEquals(otherList.size, solution.strategyCount.size)
        assertEquals(sudokuCells, solution.sudokuSolution)
    }
}