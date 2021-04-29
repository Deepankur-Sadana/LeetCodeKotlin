import java.util.*
import kotlin.collections.HashMap
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter

/**
 * Runtime: 244 ms, faster than 100.00% of Kotlin online submissions for Employee Importance.
Memory Usage: 45.3 MB, less than 100.00% of Kotlin online submissions for Employee Importance.
 */
class `690 Employee Importance` {

    class Employee {
        var id: Int = 0
        var importance: Int = 0
        var subordinates: List<Int> = listOf()
    }


    val map = HashMap<Int, Employee>()


    fun getImportance(employees: List<Employee?>, id: Int): Int {
        employees.forEach { map[it!!.id] = it }
        var res = 0
        val queue = LinkedList<Employee>()
        queue.add(map[id]!!)

        while (queue.isNotEmpty()) {
            val pop = queue.pop()
            res += pop.importance
            pop.subordinates.forEach { queue.add(map[it]!!) }
        }
        return res
    }
}