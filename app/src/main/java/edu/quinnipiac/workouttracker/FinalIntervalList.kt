package edu.quinnipiac.workouttracker

data class FinalIntervalList(
    val coolDown: String,
    val lowIntensity: String,
    val highIntensity: String,
    val sets: String,
    val name: String,
)

val finalList = mutableListOf<FinalIntervalList>()

fun getFinalName(number: Int): String{
    return List[number].name
}

fun getFinalSets(number: Int): String{
    return List[number].sets
}

fun getFinalHigh(number: Int): String{
    return List[number].highIntensity
}

fun getFinalLow(number: Int): String{
    return List[number].lowIntensity
}

fun getFinalCool(number: Int): String{
    return List[number].coolDown
}

