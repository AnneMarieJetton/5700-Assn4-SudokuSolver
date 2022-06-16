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

//solution to first file:


//Solved
//2 4 3 1
//1 3 2 4
//3 1 4 2
//4 2 1 3
//
//
//Total time: 00:00:00.0230000
//
//Strategy             Uses       Time
//Apply Changes        2          00:00:00.0130000
//Only One Possibility 1          00:00:00.0050000
//Only One Place       0          00:00:00
//Twins                0          00:00:00
//Guess                0          00:00:00