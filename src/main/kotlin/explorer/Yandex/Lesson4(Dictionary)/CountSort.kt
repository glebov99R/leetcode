package explorer.Yandex.`Lesson4(Dictionary)`

/**
 * Сортировка подсчётом
 *
 * Учених получил за семестр следующие оценки 5 2 2 3 1 3 4 5
 * Вывести отсортированный список в порядке возрастания
 * Пример 1 2 2 3 3 4 5 5
 */

fun constructor(arr: Array<Int>){

    val minval = arr.minOrNull() // Минимальоне значение массива
    val maxval = arr.maxOrNull() // Максимальное значение массива

    val k = (maxval!! - minval!! + 1) // Тут к - это длина массива из оценок

    /**
     * Здесь мы используем конструктор IntArray(k), чтобы создать массив из k элементов типа Int.
     * Второй аргумент конструктора является лямбда-выражением, которое задает начальное значение для каждого элемента массива.
     * В данном случае мы используем лямбда-выражение { 0 }, чтобы заполнить весь массив нулями. Значение count будет равно массиву, состоящему из k нулей.
     */
    val count = IntArray(k) { 0 }

    /**
     * Заполняем массив count с первого индекса
     * @param now прохолдит по всем элементам массива arr
     * @param minval наименьшиая оценка ученика
     */
    for (now in arr){
        count[now - minval] += 1
    } // [1,2,2,1,2]

    var indexCount = 0


    /**
     * @param k - длина массива = 5
     * @param value ( диапазон от 0 до 5 )
     * @param minval (1) минимальная оценка
     * @param indexCount (0 1 2 3 4 5 6 7 8) с кадым проходом цыкла запись происходит в следующий индекс
     */
    for (value in 0 until k){ // пробегаемся от 0 до 5

        for (i in 0 until count[value]){ // пробегаемся от 0 до
            arr[indexCount] = value + minval
            indexCount += 1
        }

    }
    println(arr.joinToString()) // 1, 2, 2, 3, 3, 4, 5, 5
}

/**
 * Воторой вариант решения
 */
fun constructor2(seq: IntArray) {

    val minVal = seq.minOrNull() ?: 0
    val maxVal = seq.maxOrNull() ?: 0
    val k = maxVal - minVal + 1
    val count = IntArray(k)

    for (now in seq) {
        count[now - minVal]++
    }

    var nowPos = 0

    for (value in 0 until k) {
        for (i in 0 until count[value]) {
            seq[nowPos] = value + minVal
                    nowPos++
        }
    }
    println(seq.joinToString())
}

//    constructor(arrayOf(5,88,88,3,17,3,4,5))
