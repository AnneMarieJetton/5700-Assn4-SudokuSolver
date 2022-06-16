package Parts
import kotlin.random.Random

class Cell(_rowIndex: Int, _colIndex: Int,_BoxIndex: Int, _currentValue: String, _possibleValues: MutableList<String>) {
    var id: Int = Random.nextInt(0, 10000000)
    var initialValue: String = _currentValue
    var currentValue: String = _currentValue
    var possibleValuesfailure: MutableList<String> = _possibleValues
    var possibleValues = mutableListOf<String>()
    val rowIndex: Int = _rowIndex
    val colIndex: Int = _colIndex
    var boxIndex: Int = _BoxIndex

    init {
        setPosVal()
    }

    private fun setPosVal(){
        for(value in possibleValuesfailure){
            possibleValues.add(value)
        }
    }

}