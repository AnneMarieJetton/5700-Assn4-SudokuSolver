import Parts.Cell

class Solution(_sudokuSolution: MutableList<MutableList<Cell>>, _strategyCount: MutableList<Int>) {
    var sudokuSolution: MutableList<MutableList<Cell>> = _sudokuSolution
        private set
    var strategyCount: MutableList<Int> = _strategyCount
    var sudokuSolutionPrintable: String = ""
    var strategyCountPrintable: String = ""

    init {
        createPrintables()
    }

    private fun createPrintables(){
        for(line in sudokuSolution){
            for (cell in line){
                sudokuSolutionPrintable = sudokuSolutionPrintable + cell.currentValue + " "

            }
            sudokuSolutionPrintable = sudokuSolutionPrintable + "\n"
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