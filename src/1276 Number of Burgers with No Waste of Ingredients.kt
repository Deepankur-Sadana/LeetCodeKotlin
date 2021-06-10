class `1276 Number of Burgers with No Waste of Ingredients` {

    /**
     * Runtime: 292 ms, faster than 100.00% of Kotlin online submissions for Number of Burgers with No Waste of Ingredients.
    Memory Usage: 36.7 MB, less than 100.00% of Kotlin online submissions for Number of Burgers with No Waste of Ingredients.

     */
    fun numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List<Int> {
        if (tomatoSlices < cheeseSlices * 2) return emptyList()
        if (tomatoSlices > cheeseSlices * 4) return emptyList()
        if (tomatoSlices % 2 == 1) return emptyList()
        var smallBurgers = cheeseSlices
        val remainingTomatoSlices = tomatoSlices - (cheeseSlices * 2)
        val bigBurgers = remainingTomatoSlices / 2 //steal small burger and make em big
        smallBurgers -= bigBurgers
        return listOf( bigBurgers,smallBurgers)
    }


}