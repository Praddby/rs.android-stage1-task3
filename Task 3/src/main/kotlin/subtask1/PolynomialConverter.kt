package subtask1

import kotlin.math.abs

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null
        var result = ""
        numbers.forEachIndexed { index, i ->
            var operator = if (i > 0) "+" else "-"
            if (index == 0) operator = ""
            val operand = when (index) {
                numbers.lastIndex -> ""
                numbers.lastIndex - 1 -> "x"
                else -> "x^${numbers.lastIndex - index}"
            }
            result += when (abs(i))  {
                0 -> ""
                1 -> " $operator $operand"
                else -> " $operator ${abs(i)}$operand"
            }
        }
        return result.trim()
    }
}
