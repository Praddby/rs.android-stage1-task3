package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val newArrNumber = mutableListOf<String>()
        number.forEachIndexed { index, c ->
            val numberList: MutableList<String> = number.chunked(1) as MutableList<String>
            if ( numberList.contains("-") ) return null
            if ( index < numberList.size) {
                for (n in numberPhone[c.toString()]!!) {
                    numberList[index] = n.toString()
                    newArrNumber.add(numberList.fold("") { e, i -> "$e$i" })
                }
            }
        }
        return newArrNumber.toTypedArray()
    }

    private val numberPhone = mapOf(
        "1" to listOf(2,4),
        "2" to listOf(1,3,5),
        "3" to listOf(2,6),
        "4" to listOf(1,5,7),
        "5" to listOf(2,4,6,8),
        "6" to listOf(3,5,9),
        "7" to listOf(4,8),
        "8" to listOf(5,7,9,0),
        "9" to listOf(6,8),
        "0" to listOf(8)
    )
}
