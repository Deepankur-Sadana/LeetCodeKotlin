import java.util.*
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    `735 Asteroid Collision`().asteroidCollision(intArrayOf(
        -2,-1,1,2


    ))
}
class `735 Asteroid Collision` {

    /**
     * Runtime: 276 ms, faster than 33.33% of Kotlin online submissions for Asteroid Collision.
    Memory Usage: 37.7 MB, less than 100.00% of Kotlin online submissions for Asteroid Collision.
     */
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        asteroids.forEach { it ->
            if (stack.isEmpty()) {
                stack.push(it)
            } else {
                var top = it
                while (stack.isNotEmpty() && stack.peek() * top <= -1 && top <=-1 ) {
                    if (top.absoluteValue == stack.peek().absoluteValue) {
                        stack.pop()
                        top = 0
                        break
                    } else if (top.absoluteValue > stack.peek().absoluteValue) {
                        stack.pop()
                    } else { // top.absoluteValue < stack.peek().absoluteValue
                        top = stack.pop()
                    }
                }
                if (top != 0 )stack.push(top)
            }
        }
        return stack.toIntArray()

    }
}