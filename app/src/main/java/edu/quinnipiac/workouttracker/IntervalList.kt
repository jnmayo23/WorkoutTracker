package edu.quinnipiac.workouttracker

data class IntervalList(
    val coolDown: String,
    val lowIntensity: String,
    val highIntensity: String,
    val sets: String,
    val name: String,
)

val List = mutableListOf<IntervalList>()

fun getName(number: Int): String{
    return List[number].name
}

fun getSets(number: Int): String{
    return List[number].sets
}

fun getHigh(number: Int): String{
    return List[number].highIntensity
}

fun getLow(number: Int): String{
    return List[number].lowIntensity
}

fun getCool(number: Int): String{
    return List[number].coolDown
}


