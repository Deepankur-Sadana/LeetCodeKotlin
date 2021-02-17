class `489 Robot Room Cleaner` {


    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        fun move(): Boolean


        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        fun turnLeft() {}
        fun turnRight() {}

        // Clean the current cell.
        fun clean() {}
    }


    class Solution {
        var directions =
            arrayOf(
                intArrayOf(-1, 0),//Left
                intArrayOf(0, 1),//Right
                intArrayOf(1, 0),//Top
                intArrayOf(0, -1)//Bottom
            )
        val set = HashSet<String>()
        fun cleanRoom(robot: Robot) {

        }

        fun dfs(r: Int, c: Int, robot: Robot) {
            robot.clean()
            set.add("$r-$c")

            directions.forEach { direction ->


            }
            val b = "$r-$c"
            if (set.contains(b)) return

        }
    }


}






