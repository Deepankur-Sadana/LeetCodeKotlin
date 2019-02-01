import java.awt.Color

fun String.hasSpaces() = find { it == ' ' } != null

fun extensionExamples() {
    "Does it has space ?".hasSpaces()
}

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("Green", size)


fun main(args: Array<String>) {
    staticExample()
}

fun AquariumPlant.isRed() = color == "Red"

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun AquariumPlant.print() = println("GreenLeafyPlant")


fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull()
}

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun propertyEmaple() {
    val plant = AquariumPlant("Green", 50)
    plant.isGreen
}

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print()

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()
}
