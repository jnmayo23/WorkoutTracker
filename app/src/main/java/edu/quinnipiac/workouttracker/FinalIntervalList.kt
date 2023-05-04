package edu.quinnipiac.workouttracker

data class FinalIntervalList(
//    val warmUp: String,
    val coolDown: String,
    val lowIntensity: String,
    val highIntensity: String,
    val sets: String,
    val name: String
)

val finalList = mutableListOf<FinalIntervalList>()

fun getFinalName(number: Int): String{
    return finalList[number].name
}

fun getFinalSets(number: Int): String{
    return finalList[number].sets
}

fun getFinalHigh(number: Int): String{
    return finalList[number].highIntensity
}

fun getFinalLow(number: Int): String{
    return finalList[number].lowIntensity
}

//fun getFinalWarm(number: Int): String{
//    return finalList[number].warmUp
//}

fun getFinalCool(number: Int): String{
    return finalList[number].coolDown
}

