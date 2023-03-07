package explorer.Yandex.Lesson2

import kotlin.math.max
import kotlin.math.min

/**
 * Задача:
 *
 * Дана последовательность чисел длиной N (N > 0)
 * Найти максимальное число в последовательности
 */

fun searchMaxValue(array: IntArray): Int {
    var answer = 1

    for (i in 1 until array.size){

        if (array[i] > array[answer]){
            answer = i
        }

    }
    println(answer)
    return array[answer]
}
//    searchMaxValue(array = intArrayOf(1,2,3,4,5))

/**
 * Задача:
 *
 * Дана последовательность чисел длиной N (N>1)
 * Найти максимальное число в последовательности и второе по величине число (такое,
 * которое будет максимальным, если вычеркнуть из последовательности одно максимальное число).
 */

/**
 * Решение:
 *
 * Задаём две переменные для первого и второго максимума. Возьмем превые два числа из последовательности
 * и запишем большее из них в переменную для первого максимума, а меньшее - для второго.
 * Проёдем по всей последовательности. Если очередное число больше первого максимума, то запишем
 * во второй максимум значение первого, а в перовый - текущее число. Если только больше второго,
 * запишем текущее число во второй максимум.
 */

fun prevMaxValue(array: IntArray): Pair<Int, Int> {

    var max1 = max(array[0],array[1])
    var max2 = min(array[0],array[1])

    for (i in array.indices){

        if (array[i]> max1){

            max2 = max1
            max1 = array[i]

        } else if (array[i] > max2){

            max2 = array[i]
        }

    }
    return  Pair(max1,max2)
} //  prevMaxValue(intArrayOf(1,4,5,12,3,3,5,2))


/**
 * Дана последовательность чисел длиной N
 *
 * Найти минимальное четное число в последовательности или вывести -1, если такого не существует
 */
fun minEvenNumber(array: IntArray): Int {

    var a = -1

    for (i in array.indices) {

        if ((array[i] % 2 == 0) && (a == -1 || a > array[i]) ) {
            a = array[i]
        }
    }
    println(a)
    return a
} //  minEvenNumber(intArrayOf(1,4,5,12,3,3,5,2))

