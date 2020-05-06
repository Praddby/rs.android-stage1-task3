package subtask3

import kotlin.math.abs

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var arrayInt = itemsFromArray.filterIsInstance<Int>()
        if (arrayInt.isEmpty()) return 0
        if (arrayInt.size <= numberOfItems) return sum(arrayInt).toInt()
        if (sum(arrayInt) < 0) arrayInt = smallNegativeNumber(arrayInt)
        return if (numberOfItems <= 3) maxProductOf3(arrayInt)
        else sum(absArray(arrayInt).sorted().drop(arrayInt.size - numberOfItems)).toInt()
    }

    private fun smallNegativeNumber(array: List<Int>): List<Int> {
        val arr = array.filter { it < 0 }.sorted()
        return array.filter { it != arr.last() }
    }

    private fun sum(array: List<Int>): Long = array.fold(1.toLong()) {
            previousResult, element -> previousResult * element.toLong()
    }

    private fun max(a: Int, b: Int): Int {
        return if (a >= b) a else b
    }

    private fun absArray(array: List<Int>): List<Int> {
        return array.map { abs(it) }
    }
    fun maxProductOf3(itemsFromArray: List<Int>): Int {
        var minNeg1 = -1
        var minNeg2 = -1
        var minNeg3 = -1
        var maxPos1 = 1
        var maxPos2 = 1
        var maxPos3 = 1
        for (current in itemsFromArray) {
            if (current < 0) {
                when {
                    current <= minNeg1 -> {
                        minNeg3 = minNeg2
                        minNeg2 = minNeg1
                        minNeg1 = current
                    }
                    current <= minNeg2 -> {
                        minNeg3 = minNeg2
                        minNeg2 = current
                    }
                    else -> minNeg3 = current
                }
            }
            if (current > 0) {
                when {
                    current >= maxPos1 -> {
                        maxPos3 = maxPos2
                        maxPos2 = maxPos1
                        maxPos1 = current
                    }
                    current >= maxPos2 -> {
                        maxPos3 = maxPos2
                        maxPos2 = current
                    }
                    else -> maxPos3 = current
                }
            }
        }
        return  max(minNeg1 * minNeg2 * minNeg3, maxPos1 * maxPos2 * maxPos3)
    }
}
