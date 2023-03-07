package leetcode.easy

/**
 * Дан упорядоченный по возрастанию массив положительных целых чисел arr и целое число k.
 * Нужно вернуть k-ое натуральное число, которое отсутствует в массиве arr.
 * Например, если arr = [2,3,4,7,11] и k = 5, то ответом будет 9, так как пятый пропущенный положительный целый номер равен 9.
 * Важно отметить, что в массиве может быть несколько пропущенных чисел, но мы ищем только k-ое пропущенное число.
 */

fun findKthMissingNumber(arr: IntArray, k: Int): Int {

    var leftBorder = 0 // Левая граница
    var rightBorder = arr.size - 1 // Правая граница

    while (leftBorder <= rightBorder) {

        val mid = (leftBorder + rightBorder) / 2 // центр массива
        val missing = arr[mid] - arr[0] - mid

        if (missing < k) {
            leftBorder = mid + 1
        } else {
            rightBorder = mid - 1
        }
    }
    return arr[leftBorder - 1] + k - (arr[leftBorder - 1] - leftBorder)
}

//     findKthMissingNumber(arr = intArrayOf(2,3,4,7,11), k = 2)
