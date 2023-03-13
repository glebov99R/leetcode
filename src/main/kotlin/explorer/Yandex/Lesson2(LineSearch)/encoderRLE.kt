package explorer.Yandex.`Lesson2(LineSearch)`

/**
 * Задача с собеседования
 *
 * Дана строке (возможно пустая), состоящая из букв A-Z:
 * AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBB
 *
 * Нужно написать функцию RLE, которая на выходе даст строку вида: A4B3C2XYZD4E3F3A6B28.
 * И сгенерирует ошибку, если на вход пришла невалидная строка.
 * Пояснение: Если символ встречается 1 раз, он остается без изменений;
 * Если символ повторяется более 1 раза, то к нему добавляется количество повторений.
 */

fun encodeRLE(input: String): String {

    var count = 1 // Счётчик
    var prevChar = input[0] // Предыдущий символ
    var encodedString = "" // Выходная строка

    for (i in 1 until input.length) {
        val currentChar = input[i] // Текущий символ

        if (currentChar == prevChar) { // Если предыдущий символ равен текущему то прибавляем к счётчику 1
            count++
        } else {
            encodedString += prevChar + count.toString()  // Если текущий символ не равен предыдущему то записываем в выходную строку количество символов и сам символ
            count = 1 // Обновляем счётчик
            prevChar = currentChar // записываем новый символ в prevChar
        }
    }

    encodedString +=  prevChar + count.toString()
    println(encodedString)
    return encodedString

} //  encodeRLE("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBB")

