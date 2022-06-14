package Parts

class Cell(_rowIndex: Int, _colIndex: Int,_puzzleSize: Int, _currentValue: String, _possibleValues: MutableList<String>) {
    var currentValue: String = _currentValue
    var possibleValues: MutableList<String> = _possibleValues
    val rowIndex: Int = _rowIndex
    val colIndex: Int = _colIndex
    var boxIndex: Int = 0
    val puzzleSize:Int = _puzzleSize

    init {
        createBoxIndex()
    }

    private fun createBoxIndex(){

    }

}