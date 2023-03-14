package leetcode.easy

/**
 * Вам даны заголовки двух отсортированных связанных списков list1 и list2.
 * Объедините два списка в один отсортированный список.
 * Список должен быть составлен путем соединения узлов первых двух списков.
 * Возвращает заголовок объединенного связанного списка.
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode?{

    // создаем фиктивный узел, чтобы иметь доступ к началу нового списка
    val dummyHead = ListNode(0)
    var currentNode: ListNode? = dummyHead
    var node1 = list1
    var node2 = list2

    // пока есть узлы в обоих списках, сравниваем значения и добавляем меньшее значение
    while (node1 != null && node2 != null) {
        if (node1.`val` < node2.`val`) {
            currentNode?.next = node1
            node1 = node1.next
        } else {
            currentNode?.next = node2
            node2 = node2.next
        }
        currentNode = currentNode?.next
    }

    // добавляем оставшиеся узлы из первого списка, если они есть
    if (node1 != null) {
        currentNode?.next = node1
    }

    // добавляем оставшиеся узлы из второго списка, если они есть
    if (node2 != null) {
        currentNode?.next = node2
    }

    // возвращаем первый узел нового списка
    return dummyHead.next

}

