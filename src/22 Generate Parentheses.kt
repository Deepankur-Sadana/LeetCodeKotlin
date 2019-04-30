class `22 Generate Parentheses` {


    val set = HashSet<String>()
    fun generateParenthesis(n: Int): List<String> {
        traverse("", n, 0, 0)
        val list = ArrayList<String>()
        set.forEach {
            list.add(it)
        }
        return list
    }

    private val OPENING = "("
    private val CLOSING = ")"

    fun traverse(
        formSoFar: String,
        maxCount: Int,
        openingUsed: Int,
        closingUsed: Int
    ) {

        println("pathSoFar $formSoFar + openingUsed +$openingUsed + closingUsed $closingUsed")

        if(openingUsed>maxCount)return

        if (openingUsed == maxCount && closingUsed == maxCount) {
            set.add(formSoFar)
            return
        }

        if (closingUsed >= maxCount || closingUsed >= maxCount) return


        if (openingUsed == closingUsed) {
            traverse(
                formSoFar + OPENING,
                maxCount,
                openingUsed + 1,
                closingUsed
            )
        } else if (openingUsed > closingUsed) {
            traverse(
                formSoFar + OPENING,
                maxCount,
                openingUsed + 1,
                closingUsed
            )

            traverse(
                formSoFar + CLOSING,
                maxCount,
                openingUsed,
                closingUsed + 1
            )
        }

    }
}

fun main() {
    `22 Generate Parentheses`().generateParenthesis(4)
}