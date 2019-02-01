

fun makeMyHero(realName: String, heroName: String, make: (String, String) -> String) {
    val result = make(realName, heroName)
    println(result)
}

fun main(args: Array<String>) {
    val make: (String, String) -> String = { realName, heroNAme -> "$realName is now $heroNAme" }
//    makeMyHero("Deepankur","Batman",make)
    makeMyHero("Deepankur", "Batman") { realName, heroName ->
        "$realName is now $heroName"
    }
    delegate()
}


fun delegate() {
    val pleco = Plecostomus()
    println("Fish has has color ${pleco.color}")
    pleco.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Plecostomus(fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("eat a lot of algae"),
    FishColor by fishColor