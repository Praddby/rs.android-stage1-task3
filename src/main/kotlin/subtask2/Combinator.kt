package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        var result: Int? = null
        for (n in 1..array[1]) {
            if (factorial(array[1])/factorial(n) * factorial(n-array[1]) == array[0]) {
                result = n
                break
            }
        }
        return result
    }

    private fun factorial(n: Int): Int {
        if(n == 0 || n == 1) return 1
        return n * factorial(n-1)
    }
}
