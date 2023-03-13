package explorer.Yandex.`Lesson3(Many)`

/**
 * Дана последовательность положительных чисел длиной N и число X
 *
 * Нужно найти два различных числа A и В из последовательности,
 * таких что А + В = Х или вернуть пару 0,0 если такой пары чисел нет.
 *
 * Переберём число А за О(N).
 * Переберём число В за О(N).
 * Если сумма равна Х, то вернем эту пару.
 * Решение будет О(N^2) - не оптимизированное
 */

fun task2(nums: Array<Int>, x: Int): Pair<Int,Int> {

    for (i in nums.indices) {
        for (j in i+1 until nums.size) {
            if (nums[i] + nums[j] == x) {
                println("${nums[i]},${nums[j]}")

            }
        }
    }
    return Pair(0, 0)

}

/**
 * Оптимизируем решение и решим задачу за  O(N)
 *
 * Будем хранить все уже обработанные числа в множестве.
 * Если очередное число nownum, а Х - nownum есть в множетсве, то мы нашли слагаемые
 */

fun task2Optimization(nums: Array<Int>, x: Int): Pair<Int,Int> {

    val mutableSet: MutableSet<Int> = mutableSetOf() // Обьявляем множетсво

    for (nownum in nums){ // Пробегаемся по массиву nums

        /**
         *  Если х - текущий элемент массива = элементу который уже лежит в множестве
         *  то выводим пару (nownum и x - nownum)
         *  В результате получаем пару которая в сумме даёт х
         */
        if ((x - nownum) in mutableSet){
            println("$nownum,${x-nownum}")
            return Pair(nownum,x - nownum)
        }
        mutableSet.add(nownum)
    }
    return Pair(0,0)
}


//fun main(){
//    task2Optimization(nums = arrayOf(3,2,4,1,1,1), x = 7)
//}