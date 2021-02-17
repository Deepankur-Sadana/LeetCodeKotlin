class `80 Remove Duplicates from Sorted Array II` {


    fun removeDuplicates(arr: IntArray): Int {
        if (arr.size <= 2) return arr.size

        var slow = 0
        var fast = 0

        while (fast != arr.size) {
            val num = arr[fast]
            //Read
            var count = 0

            //[1,1,1,2,2,3],

            while (fast != arr.size) {
                if (fast != arr.size && arr[fast] != arr[fast + 1])
                    count++
                fast++
            }


            //write
            if (count == 1) {
                arr[slow] = num
                slow += 1
            } else if (count > 1) {
                arr[slow] = num
                arr[slow + 1] = num
                slow += 2
            }

//            //read
//            if (fast == arr.size - 2) {
//
//            }

//            fast ++

        }

        return slow + 1
    }
}