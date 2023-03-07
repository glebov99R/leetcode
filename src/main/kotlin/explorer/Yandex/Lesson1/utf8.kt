package explorer.Yandex.Lesson1

/**
 * Дана строка в кодировке (UTF-8)
 * Найти самый часто встречающийся в ней символ.
 * Если несколько символов встречаются одинаково часто, то можно вывести любой.
 */

//    variant1()
//    variant2()
//    variant3()
//    variant4()

fun variant1(){

    /**
     * Переберём все позиции и для каждой позиции в строке еще раз переберем все позиции
     * и в случае совпадения прибавим к счётчику единицу.
     * Найдём максимальное значение счётчика
     * Сложность такого алгоритма = O(N^2)
     */

    val word = readLine() // Чтение строки с клавиатуры
    var frequentSymbol = "" // Пустая строка (самая частая буква)
    var quantitySymbolInWord = 0 // Сколько раз буква встечалась в строке (изначально 0)

    for (i in 0 until word!!.length){ // пробегаемся по диапазону от 0 до длины слова
        var count = 0 // При первой итерации количество совпадений 0
        for (element in word){ // Снова пробегаемся по строке первым елементом самой строки
            if (word[i]== element){ // Если елемент текущей итерации равен элементу в слове увеличиваем счётчик на 1
                count += 1
            }
            if (count > quantitySymbolInWord){
                frequentSymbol = word[i].toString()
                quantitySymbolInWord = count
            }
        }
    }
    println(frequentSymbol)

}

fun variant2(){

    /**
     * Переберём все символы, встречающиеся в строке, а затем переберём все позиции и в случает совпадения прибавим к счётчику 1
     * Найдём максимальное значнение счётчика
     * Сложность такого алгоритма = O(N*K)
     */

    val word = readLine() // Чтение строки с клавиатуры
    var frequentSymbol = "" // Пустая строка (самая частая буква)
    var quantitySymbolInWord = 0 // Сколько раз буква встечалась в строке (изначально 0)

    /**
     * Set в Kotlin представляет собой коллекцию уникальных элементов без определенного порядка.
     * Он используется для хранения коллекции значений, где каждое значение может присутствовать только один раз.
     */
    for (currentSymbol in setOf(word)) { // Имея текущий символ пробегаемся по строке

        var count = 0

        for (element in setOf(word)){

            if (currentSymbol == element){ // Если текущий символ встречается в строке то прибавляем к счётчику 1
                count += 1
            }

            if (count > quantitySymbolInWord){
                frequentSymbol = currentSymbol.toString()
                quantitySymbolInWord = count
            }

        }
    }
    println(frequentSymbol)

}

fun variant3() {

    /**
     * Заведём словарь, где ключом является символ, а значением - сколько раз он встетился.
     * Если символ встетился впервые - создаём элемент словаря с ключом, совпадающем с этим символом и значением ноль.
     * Прибавляем к элементу словаря с ключом, совпадающем с этим символом, единицу.
     * Сложность такого алгоритма = O(N+K) = O(N)
     */


    val word = readLine() // Чтение строки с клавиатуры

    if (word != null && word.isNotEmpty()) {

        var frequentSymbol = "" // Пустая строка (самая частая буква)
        var quantitySymbolInWord = 0 // Сколько раз буква встечалась в строке (изначально 0)
        val myMap = mutableMapOf<Char, Int>() // Создам словарь где символ-ключ, а число-значение

        for (currentSymbol in word) { // Пробегаемся символом(ключем) по строке
            if (currentSymbol !in myMap) { // C помощью цикла записываем в словать то количество раз сколько символы повторялись
                myMap[currentSymbol] = 0
                myMap[currentSymbol] = myMap[currentSymbol]!! + 1
            } else {
                myMap[currentSymbol] = myMap[currentSymbol]!! + 1
            }
        }

        for (key in myMap.keys) { // Пробегаемся по ключам словаря и выбираем луший
            if (myMap[key]!! > quantitySymbolInWord) {
                quantitySymbolInWord = myMap[key]!!
                frequentSymbol = key.toString()
            }
        }
        println(frequentSymbol)
    } else {
        println("Введена пустая строка")
    }
}

fun variant4(){

    /**
     * readLine() читает строку из стандартного потока ввода (клавиатуры) и возвращает ее в виде строки типа String.
     * Метод groupingBy { it }.eachCount() создает карту, которая содержит количество каждого символа в строке s.
     * maxByOrNull { it.value }?.key выбирает ключ с максимальным значением в карте (т.е. символ, который встречается чаще всего в строке s) и выводит его.
     * Если карта пустая (например, если входная строка была пустой), то метод вернет null, поэтому используется оператор ?.
     * для безопасной навигации по возможному null значению.
     */

    val s = readLine()!!
    println(s.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key)
}