import Parts.Cell

class Solution(_sudokuSolution: MutableList<Cell>, _strategyCount: MutableList<Int>) {
    var sudokuSolution: MutableList<Cell> = _sudokuSolution
        private set
    var strategyCount: MutableList<Int> = _strategyCount
    var sudokuSolutionPrintable: String = ""
    var strategyCountPrintable: String = ""

    init {
        createPrintables()
    }

    private fun createPrintables(){
        var index = 0
        for(cell in sudokuSolution){
            sudokuSolutionPrintable = sudokuSolutionPrintable + cell.currentValue + " "
            index++

            if (index.toDouble() == Math.sqrt(sudokuSolution.size.toDouble())) {
                sudokuSolutionPrintable = sudokuSolutionPrintable + "\n"
                index = 0
            }
        }

        var methodNames = mutableListOf<String>()
        methodNames.add("numbersFoundElsewhere: ")
        methodNames.add("onlyOneOption: ")
//        methodNames.add("onlyOnePlace: ")
        methodNames.add("duplicates: ")
        methodNames.add("guess: ")

        var iterator = 0
        for (method in methodNames){
            strategyCountPrintable = strategyCountPrintable + method + strategyCount[iterator] + "\n"
            iterator++
        }

    }

}