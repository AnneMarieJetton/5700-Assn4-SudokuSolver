import java.io.File

fun main(args: Array<String>) {

    var file = File("Puzzle-4x4-0001.txt")

    var sudokuSolver = SudokuSolver(file)

    sudokuSolver.solveSudoku()

    if (sudokuSolver.solutions.size == 0){
        println("Invalid puzzle: No solution")
    }
    else if(sudokuSolver.solutions.size == 1){
        println("solution: ")
        println()
        println(sudokuSolver.solutions[0].sudokuSolutionPrintable)
        println()
        println("Strategy Stats: ")
        println()
        println(sudokuSolver.solutions[0].strategyCountPrintable)
    }
    else{
        println("Invalid puzzle: multiple solutions")
        for(solution in sudokuSolver.solutions){
            println("-------------------------------------------------")
            println(solution.sudokuSolutionPrintable)
            println()
            println(solution.strategyCountPrintable)
            println("-------------------------------------------------")
        }
    }

}