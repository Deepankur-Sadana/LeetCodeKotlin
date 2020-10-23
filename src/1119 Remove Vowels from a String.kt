class `1119 Remove Vowels from a String` {

    /**
     * Details
    Runtime: 152 ms, faster than 65.63% of Kotlin online submissions for Remove Vowels from a String.
    Memory Usage: 34.5 MB, less than 25.00% of Kotlin online submissions for Remove Vowels from a String.
     */
    fun removeVowels(S: String): String {
        val set = HashSet<Char>()
        set.add('a')
        set.add('e')
        set.add('i')
        set.add('o')
        set.add('u')

        var res = ""
        S.forEach {
            if (set.contains(it).not()) {
                res += it
            }
        }
        return res
    }
}

/**
 * Runtime: 136 ms, faster than 87.50% of Kotlin online submissions for Remove Vowels from a String.
Memory Usage: 32.9 MB, less than 25.00% of Kotlin online submissions for Remove Vowels from a String.
 */

fun removeVowels(S: String): String {
    val set = HashSet<Char>()
    set.add('a')
    set.add('e')
    set.add('i')
    set.add('o')
    set.add('u')

    var res = StringBuilder()
    S.forEach {
        if (set.contains(it).not()) {
            res.append(it)
        }
    }
    return res.toString()
}

class Optimize{

    /**
     * Runtime: 152 ms, faster than 65.63% of Kotlin online submissions for Remove Vowels from a String.
    Memory Usage: 32.6 MB, less than 25.00% of Kotlin online submissions for Remove Vowels from a String.
     */
    fun removeVowels(S: String): String {
        val set = HashSet<Char>()
        set.add('a')
        set.add('e')
        set.add('i')
        set.add('o')
        set.add('u')
        val buff = IntArray(26)
        buff['a' - 'a'] = -1
        buff['e' - 'a'] = -1
        buff['i' - 'a'] = -1
        buff['o' - 'a'] = -1
        buff['u' - 'a'] = -1


        var res = StringBuilder()
        S.forEach {
            if(buff[it-'a'] != -1)
                res.append(it)
        }
        return res.toString()
    }
}