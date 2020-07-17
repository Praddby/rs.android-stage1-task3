package subtask4

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        val result = decomposer (number, number.toLong() * number.toLong())
        return result?.subList(0, result.size-1)?.toTypedArray()
    }

    private fun decomposer(x: Int, y: Long): MutableList<Int>? {
        if (y.toInt() == 0) {
            return arrayListOf(x)
        }
        for (i in x-1 downTo 0) {
            if ((y - i.toLong() * i.toLong()) >= 0) {
                val arr = decomposer(i, (y - i.toLong() * i.toLong()))
                arr?.let{
                    arr.add(x)
                    return arr
                }
            }
        }
        return null
    }
}
