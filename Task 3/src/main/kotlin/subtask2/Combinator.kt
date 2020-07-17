package subtask2

import java.math.BigInteger

class Combinator {
    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        println(array[0])
        print(array[1])
        var result: Int? = null
        for (n in 1 until array[1]) {
            if (n < 10) {
                val sum = factorial(array[1]) / (factorial(n) * factorial(array[1] - n))
                if (sum == array[0]) {
                    result = n
                    break
                }
            } else {
                val sum1 = factorialB(array[1]) / (factorialB(n) * factorialB(array[1] - n))
                if (sum1.toInt() == array[0]) {
                    result = n
                    break
                }
            }
        }
        return result
    }

    private fun factorial(n: Int ): Int  {
        if(n == 0 || n == 1) return n
        return n * factorial(n-1)
    }

    private fun factorialB(n: Int): BigInteger {
        var ret = BigInteger.ONE
        for (i in 1..n) ret = ret.multiply(BigInteger.valueOf(i.toLong()))
        return ret
    }
}
