import java.lang.Exception
import java.lang.IndexOutOfBoundsException


fun main(array: Array<String>) {

//    `Element in Infinite Sorted List (Without size method)`().findElement()

}

class `Element in Infinite Sorted List (Without list#size method)` {


    fun main() {
        val list = listOf("", "", "")
        val toFind = list[1]
        findElement(list, toFind)

    }

    private fun <T> findElement(
        list: List<T>,
        element: T
    ): Int
            where /*T : CharSequence,*/ T : Comparable<T> {

        var index = 0
        while (true) {
            if (isInBounds(list, index)) {
                if (list[index] == element) return index
                if (list[index] > element) {
                    return binarySearch(list, index / 2, index, element)
                }
            } else { /// IOOB exception
                return binarySearch(list, index / 2, index, element)
            }
            if (index == 0) index = 1
            index *= 2

        }
    }

    private fun <T> isInBounds(list: List<T>, index: Int): Boolean {
        return try {
            list[index]
            true
        } catch (exc: IndexOutOfBoundsException) {
            false
        }
    }


    private fun <T> binarySearch(
        list: List<T>,
        left: Int,
        right: Int,
        x: T
    ): Int where T : Comparable<T> {
        val mid = (left + right) / 2
        TODO("")/** right param can be Out of bounds*/
    }
}