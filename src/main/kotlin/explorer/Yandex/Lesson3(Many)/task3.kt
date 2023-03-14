package explorer.Yandex.`Lesson3(Many)`

/**
 * Задача 2
 *
 * Дан словарь из N слов, длина каждого не превосходит К
 *
 * В записи каждого из М слов текст (каждое длиной до К)
 * может быть пропущена одна буква. Для каждого слова
 * сказать, входит ли оно (возможно, с одной пропущенной буквой), в словарь
 */

/**
 * Решение за О(NK + M)
 *
 * Выбросим из каждого слова словаря по одной букве всеми возможными способави за О(NK)
 * и положим получившиеся слова в множества
 *
 * Для кадого слова из текста просто проверим, есть ли оно в словаре за О(1)
 *
 * Изменил синтаксис функции на синтаксис Kotlin.
 * Изменил goodwords на mutableSetOf<String>, а не на set() в Python.
 * Добавил goodwords.addAll(dictionary), чтобы добавить все слова из dictionary в набор goodwords.
 * Изменил внутренний цикл, чтобы он перебирал 0 until word.length, а не range(len(word)).
 * Изменил вызов метода add() на использование substring() вместо среза строк.
 * Создал пустой MutableList типа Boolean, чтобы хранить результаты.
 * Изменил цикл на разбиение text на слова с помощью split(" ").
 * Добавил каждый результат в список ans с помощью add(), а не append().
 * В конце функции вернул ans.
 */
fun task4(dictionary: List<String>, text: String): List<Boolean>{

    val goodwords = mutableSetOf<String>()

    goodwords.addAll(dictionary)

    for (word in dictionary) {
        for (delpos in word.indices) {
            goodwords.add(word.substring(0, delpos) + word.substring(delpos + 1))
        }
    }

    val ans = mutableListOf<Boolean>()
    for (word in text.split(" ")) {
        ans.add(word in goodwords)
    }
    println(ans)
    return ans
}

//fun main(){
//    task4(dictionary = listOf("пока","привт","прощай","давай",), text = "привет")
//}