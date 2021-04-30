class `125 Valid Palindrome` {

    /**
     * Runtime: 188 ms, faster than 90.94% of Kotlin online submissions for Valid Palindrome.
    Memory Usage: 35.6 MB, less than 84.69% of Kotlin online submissions for Valid Palindrome.
     */
    fun isPalindrome(s: String): Boolean {
        var slow = 0
        var fast = s.length - 1
        while (slow < fast) {
            if (Character.isLetterOrDigit(s[slow]).not()) {
                slow++
                continue
            }

            if (Character.isLetterOrDigit(s[fast]).not()) {
                fast--
                continue
            }
            if (Character.toLowerCase(s[slow]) != Character.toLowerCase(s[fast])) return false
            slow++
            fast--

        }
        return true
    }


}
