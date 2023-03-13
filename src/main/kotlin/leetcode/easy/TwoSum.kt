/**
 * Two sum(easy)
 *
 * Дан массив целых чисел nums и целое число target. Необходимо найти два числа в массиве, которые в сумме дают значение target, и вернуть их индексы в виде массива.
 * Предполагается, что каждый входной массив имеет ровно одно решение, и каждый элемент массива может быть использован только один раз.
 * Возвращаемый массив может быть любым по порядку элементов.
 */

fun twoSum(nums: Array<Int>, target: Int): IntArray {

    val map = HashMap<Int, Int>() // Create HashMap

    for (i in nums.indices) { // пробегаемся по массиву

        val complement = target - nums[i] // complement = target - (текщий значение массива под индексом i)

        if (map.containsKey(complement)) { // проверяет если в map ключ равный complement

            /**
             * Если ключ есть то возвращается массив с двумя элементами
             * 1) map с ключём complement
             * 2) текущий инедкс
             */
            return intArrayOf(map[complement]!!, i)
        }

        /**
         * Затем на каждой итерации цикла for
         * код добавляет в этот объект новую пару,
         * где ключ - nums[i]
         * Значением — i(текущий идекс массива).
         */
        map[nums[i]] = i
    }
        throw IllegalArgumentException("No two sum solution")
}

//    twoSum(nums = arrayOf(2,7,11,15), target = 9)
