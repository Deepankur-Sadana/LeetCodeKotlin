
class Utils {

    companion object {

        fun printArray(matrix: Array<CharArray>) {
            matrix.forEach {
                println(it)
            }
        }


        fun printArray(matrix: Array<IntArray>) {
            matrix.forEach {
                it.forEach { value -> print("$value ") }
                println()
            }
        }

    }
}