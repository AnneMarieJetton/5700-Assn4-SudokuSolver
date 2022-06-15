package Strategies

import Parts.Cell
import SolveTemplate

class OnlyOnePossibility: SolveTemplate {

    override fun runStrategy(sudokuCells: MutableList<Cell>): Boolean {

        return false
    }

}