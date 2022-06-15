import Parts.Cell

interface SolveTemplate {
    //strategy?

    //Template
    abstract fun runStrategy(sudokuCells: MutableList<Cell>): Boolean

    fun checkRow(){

    }

    fun checkCol(){

    }

    fun checkBox(){

    }

    fun checkPossibleValues(cell: Cell){

    }

    fun removepossibleValue(){

    }

}