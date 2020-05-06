package subtask3

import kotlin.math.abs

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var arrayInt = itemsFromArray.filterIsInstance<Int>()
        if (arrayInt.isEmpty()) return 0
        if (arrayInt.size <= numberOfItems) return sum(arrayInt).toInt()
        if (sum(arrayInt) < 0) arrayInt = smallNegativeNumber(arrayInt)
        return sum(absArray(arrayInt).sorted().drop(arrayInt.size - numberOfItems)).toInt()
    }

    private fun smallNegativeNumber(array: List<Int>): List<Int> {
        val arr = array.filter { it < 0 }.sorted()
        return array.filter { it != arr.last() }
    }

    private fun sum(array: List<Int>): Long = array.fold(1.toLong()) {
            previousResult, element -> previousResult * element.toLong()
    }

    private fun absArray(array: List<Int>): List<Int> {
        return array.map { abs(it) }
    }
}
