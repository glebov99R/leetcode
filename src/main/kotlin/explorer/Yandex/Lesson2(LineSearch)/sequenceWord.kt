package explorer.Yandex.`Lesson2(LineSearch)`

/**
 * Здача
 *
 * Дана последовательность слов
 *
 * Вывести все самые короткие слова через пробел
 */

fun sequenceOfWord(words: Array<String>): String {

    var minlen = words[0].length
    var ans: Array<String> = arrayOf()

    for (word in words){

        if (word.length < minlen){
            minlen = word.length
        }
    }

    for (word in words){
        if (word.length == minlen){
            ans += word
        }
    }
    println(ans.joinToString(" "))
    return ans.joinToString(" ")
} //  sequenceOfWord(arrayOf("gbbb","aaab","f","pfpf"))
