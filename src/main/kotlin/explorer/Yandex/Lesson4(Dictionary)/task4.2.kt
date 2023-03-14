package explorer.Yandex.`Lesson4(Dictionary)`

/**
 * Задача 2
 *
 * На шахмотной доске N * N находястя M ладей (ладья бьет клетки на той же горизонтали или вертикали до ближайшей занятой)
 *
 * Определите, сколько пар леюдей бьют друг друга.
 * Ладьи задаются парой чисел I и J, обозначающих координаты клетки.
 * 1<= N 10^9, 0 <= M <= 2 * 10^5
 *
 * Решение:
 * Для каждой занятой горизонтали и вертикали будем хранить количество ладей на них.
 * Количество пар в горизонтали (вертикали) == количество ладей -1.
 * Суммируем это количество пар для всех горизонталей и вертикалей.
 */

fun addrook(roworcol: MutableMap<Int,Int>,key: Int){
    if (key !in roworcol) roworcol[key] = 0
    roworcol[key] = roworcol[key]!! + 1
}



fun chess(rookcoolrds: List<Pair<Int, Int>>) {

    val rooksinrow = mutableMapOf<Int,Int>() // Славарь сколько ладей стоит в строке
    val rooksincol = mutableMapOf<Int,Int>() // Славарь сколько ладей стоит в столбце

    for (coord in rookcoolrds){
        val row = coord.first
        val col = coord.second
        addrook(rooksinrow, row)
        addrook(rooksincol, col)
    }
}


fun main() {

}