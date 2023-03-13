package explorer.Yandex.`Lesson3(Many)`

val setSize = 10 // Количество списков в списке
var  mySet = Array(setSize) { mutableListOf<Int>() } // Список состоящий из 10-ти пустых списков (Двумерный)

/**
 * Функция добавления элемента в множество
 */
fun add(x: Int){
    mySet[x % setSize] += x // в остатке от деления получаем разряд единиц  и записываем x в список под этим индексом
    for (list in mySet) {
        for (element in list) {
            print("$element ")
        }
        println()
    }
}

/**
 * Функция линейного поиска элемента в множетсве
 * @param x - значение которое мы хотим найти
 */
fun find(x: Int): Boolean { // Функция возвращает булевое значение true - если элемент x существует в списке
    for (now in mySet[x % setSize]){ // производим поиск в списке который находится под индексом который равен остатку от деления x на 10
        if (now == x){
            return true
        }
    }
    return false
}

/**
 * Функция удаления элемента из множества
 * @param x - число которое мы хотим удалить
 */
fun delete(x: Int){

   val xList = mySet[x % setSize] // Определяем номер списка

    for (i in xList.indices){

        /**
         * Этот код устанавливает значение последнего элемента списка xList на место элемента xList[i],
         * а затем значение элемента xList[i] на место последнего элемента списка xList.
         */
        if (xList[i] == x){
            xList[i] = xList[xList.size - 1]
            xList.removeLast() // Удаление последнего элемента в списке
            return
        }

    }
}

fun printArray(arr: Array<Int>){
    for (row in arr) {
        for (col in 0 until row) {
            print("$col ")
        }
        println() // переход на новую строку после вывода всех элементов строки
    }
}

//fun main(){
//    add(3)
//    add(13)
//    add(33)
//    add(103)
//    add(4)
//    delete(4)
//    add(5)
//}