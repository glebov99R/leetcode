package explorer.Yandex.Lesson2

/**
 * Дана последовательность чисел длиной N
 *
 * Найти последнее (правое) вхождение числа X
 * в неё или вывести -1, если число X не встречалось
 */


fun firstRightEntry(array: IntArray, x: Int): Int {

    var answer = -1

    for(i in array.indices){

       if (array[i] == x){
           answer = i
       }

    }
    return answer
}