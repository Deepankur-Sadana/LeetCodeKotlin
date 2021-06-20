import java.lang.StringBuilder

class `929 Unique Email Addresses` {


    /**
     * Runtime: 232 ms, faster than 81.16% of Kotlin online submissions for Unique Email Addresses.
    Memory Usage: 36.8 MB, less than 84.06% of Kotlin online submissions for Unique Email Addresses.

     */
    fun numUniqueEmails(emails: Array<String>): Int {
        val set = HashSet<String>()

        emails.forEach {
            val array: List<String> = it.split("@")
            val local = array[0]
            val domain = array[1]

            val  builder = StringBuilder()

            val charArr = local.toCharArray()
            for (i in charArr.indices) {
                val char = charArr[i]
                if (char == '+') break
                if (char != '.') {
                    builder.append(char)
                }
            }
            set.add("$builder@$domain")


        }
        return set.size

    }


}