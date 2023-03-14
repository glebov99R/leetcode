package explorer.Yandex.`Lesson4(Dictionary)`

/**
 * Задача 4.1
 *
 * Дано два числа X и Y без ведущих нулей.
 * Необходимо проверить, можно ли получить первое из второго перестановкой цифр.
 *
 * Решение:
 * Посчитаем кол-во вхождений каждой цифры  в каждое из чисел и сравним.
 * Цифры будем постепенно добавлять из числа справа с помощью % 10 и div(оператор выполняет целочисленное деление, игнорируя дробную часть) 10
 */


// Функция отвечает за обработку чисел X и Y
fun countDigits(num: Int): IntArray {

    val digitsCount = IntArray(10) { 0 } // Создаём массив заполненный нулями из 10 элементов

    var numCopy = num // Создаём буферную переменную numCopy

    while (numCopy > 0){ // Пока переменная numCopy не 0 цикл будет выполняться

        val lastDigit = numCopy % 10 // С помощью оператора остатка от деления "%" записываем в переменную lastDigit последнюю цифру справа  от текущего значения числа numCopy при каждой итерации

        digitsCount[lastDigit] += 1 // Заполняем массив количеством одинаковых цифр в зависимости от индекса индекс соответствует цифре благодаря прибавление единицы

        numCopy = numCopy.div(10) // С помощью оператора div отнимаем по одной цифре из числа справа
    }

    return digitsCount // Возвращаем массив, пример [0,3,1,0,0,0,0,0,0,0]
}

/**
 * Функция принимает на вход два числа и возвращает true или false в зависимостри от того можно ли получить первое число из цифр второго
 * @param x - первое число
 * @param y - второе число
 */
fun twoNum(x: Int, y: Int): Boolean {

    val digitsX = countDigits(x) // digitsX, пример [0,3,1,0,0,0,0,0,0,0] (Если кол-во цифр равное)
    val digitsY = countDigits(y) // digitsY, пример [0,3,1,0,0,0,0,0,0,0] (Если кол-во цифр равное)

    for(digit in 0 until 10){ // Перебираем индексы от 0 до 10

        if (digitsX[digit] != digitsY[digit] ){ // Сравниваем элементы двух массивов по индексу

            println("false")
            return false //  Если элементы с под равным индексом не равны то возвращаем false(числа не равны)
        }
    }
    println("true")
    return true //  Если элементы с под равным индексом равны то возвращаем true(числа равны)
}


//    twoNum(1112,2111)