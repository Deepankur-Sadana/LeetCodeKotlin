open class WaterSupply(var needsProcess: Boolean) {

}

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() = apply { needsProcess = false }
}

class LakeWater : WaterSupply(true) {
    fun filter() = apply { needsProcess = false }
}

class Aquarium<T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcess) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }


}

//inline fun <reified R : WaterSupply>  hasWaterSupplyOfType() = waterSupply is R

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun isWaterClean(aquarium: Aquarium<WaterSupply>) {
        print(aquarium.waterSupply.needsProcess)
    }

    fun <T : WaterSupply> isClear(aquarium: Aquarium<T>) {
        println("aquarium water is clean : $${aquarium.waterSupply.needsProcess}")
    }

    fun main(array: Array<String>) {
        val cleaner = TapWaterCleaner()
        val aquarium = Aquarium(TapWater())
        aquarium.addWater(cleaner)
        isClear(aquarium)
//        aquarium.hasWaterSupplyOfType<TapWater>()
    }
}