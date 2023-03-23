package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    try {
        validatePage(pobi, crong)
    } catch (e: IllegalArgumentException) {
        return -1
    }

    val MAX_POBI: Int = max(findMax(pobi[0]), findMax(pobi[1]))
    val MAX_CRONG: Int = max(findMax(crong[0]), findMax(crong[1]))

    if (MAX_POBI > MAX_CRONG) {
        return 1
    }
    if (MAX_POBI < MAX_CRONG) {
        return 2
    }
    return 0
}

private fun findMax(number: Int): Int {
    val numberStr = number.toString()
    var sum = 0
    var multi = 1

    for (n in numberStr) {
        sum += n.digitToInt()
        multi *= n.digitToInt()
    }
    return max(sum, multi)
}

private fun validatePage(pobi: List<Int>, crong: List<Int>) {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) {
        throw IllegalArgumentException("페이지의 차이는 1이어야 한다.")
    }
}

fun main() {
    println(solution1(listOf(97, 98), listOf(197, 198)))
    println(solution1(listOf(131, 132), listOf(211, 212)))
    println(solution1(listOf(99, 102), listOf(211, 212)))
}
