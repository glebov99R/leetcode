package explorer.Yandex.Lesson2

/**
 * Дана последовательность чисел длиной N
 *
 * Найти первое (левое) вхождение положительного числа X
 * в неё или вывести -1, если число X не встречалось
 */

fun firstLeftEntry(array: IntArray, x: Int): Int {

    var answer = -1 // если число X не встретится то решением будет -1

    for (i in array.indices){

        if ( (answer == -1) && array[i] == x ){
            answer = i
        }

    }
    return answer
}


// firstLeftEntry(array = intArrayOf(1,2,5,2), x = 1)
